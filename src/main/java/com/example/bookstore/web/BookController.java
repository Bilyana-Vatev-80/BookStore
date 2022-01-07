package com.example.bookstore.web;

import com.example.bookstore.model.binding.BookAddBindingModel;
import com.example.bookstore.model.binding.BookUpdateBindingModel;
import com.example.bookstore.model.entity.enums.CategoryEnum;
import com.example.bookstore.model.entity.enums.LanguageEnum;
import com.example.bookstore.model.service.BookAddServiceModel;
import com.example.bookstore.repository.CategoryRepository;
import com.example.bookstore.serice.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;
    private final PublishingHouseService publishingHouseService;
    private final ShoppingCartService shoppingCartService;
    private final RequestsStatsService requestsStatsService;
    private final WishlistService wishlistService;
    private final PagesViewCountService pagesViewCountService;
    private final CategoryRepository categoryRepository;


    public BookController(BookService bookService, ModelMapper modelMapper, PublishingHouseService publishingHouseService, ShoppingCartService shoppingCartService, RequestsStatsService requestsStatsService, WishlistService wishlistService, PagesViewCountService pagesViewCountService, CategoryRepository categoryRepository) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.publishingHouseService = publishingHouseService;
        this.shoppingCartService = shoppingCartService;
        this.requestsStatsService = requestsStatsService;
        this.wishlistService = wishlistService;
        this.pagesViewCountService = pagesViewCountService;
        this.categoryRepository = categoryRepository;
    }
//TODO to delete categoryRepository from constructor
    @GetMapping("/all")
    public String allBook(Model model){
        model.addAttribute("books",bookService.findAllBooks());
        return "all-books";
    }

    @GetMapping("/order-by-title")
    public String allBooksByTitle(Model model){
        model.addAttribute("books",bookService.findAllBooksOrderByTitle());
        return "all-books";
    }

    @GetMapping("/order-by-author")
    public String allBooksByAuthor(Model model){
        model.addAttribute("books",bookService.findAllBooksOrderByAuthor());
        return "all-books";
    }

    @GetMapping("/best-selling")
    public String allBooksByBestSelling(Model model){
        model.addAttribute("books",bookService.findAllBooksByOrderByBestSelling());
        return "all-books";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("languages", LanguageEnum.values());
        model.addAttribute("categories", CategoryEnum.values());
        model.addAttribute("publishingHouse",publishingHouseService.findAllPublishingHouseNames());
        return "add-book";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid BookAddBindingModel bookAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              @AuthenticationPrincipal UserDetails principal){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("bookAddBindingModel", bookAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.bookAddBindingModel", bindingResult);

            return "redirect:/books/add";
        }

        BookAddServiceModel bookAddServiceModel = modelMapper
                .map(bookAddBindingModel, BookAddServiceModel.class);

        bookAddServiceModel.setCreator(principal.getUsername());

        Long bookId = bookService.add(bookAddServiceModel);

        return "redirect:/books/"; //TODO add bookId
    }

    @ModelAttribute("bookUpdateBindingModel")
    public BookUpdateBindingModel bookUpdateBindingModel(){
        return new BookUpdateBindingModel();
    }

    @ModelAttribute("bookAddBindingModel")
    public BookAddBindingModel bookAddBindingModel(){
        return new BookAddBindingModel();
    }
}
