package com.example.bookstore.web;

import com.example.bookstore.model.binding.BookAddBindingModel;
import com.example.bookstore.model.binding.BookUpdateBindingModel;
import com.example.bookstore.model.entity.enums.CategoryEnum;
import com.example.bookstore.model.entity.enums.LanguageEnum;
import com.example.bookstore.model.service.BookAddServiceModel;
import com.example.bookstore.model.service.BookUpdateServiceModel;
import com.example.bookstore.model.view.BookDetailViewModel;
import com.example.bookstore.repository.CategoryRepository;
import com.example.bookstore.serice.*;
import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static com.example.bookstore.constant.GlobalConstants.*;

import javax.validation.Valid;
import java.io.IOException;

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
    private final ReviewService reviewService;


    public BookController(BookService bookService, ModelMapper modelMapper, PublishingHouseService publishingHouseService, ShoppingCartService shoppingCartService, RequestsStatsService requestsStatsService, WishlistService wishlistService, PagesViewCountService pagesViewCountService, CategoryRepository categoryRepository, ReviewService reviewService) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.publishingHouseService = publishingHouseService;
        this.shoppingCartService = shoppingCartService;
        this.requestsStatsService = requestsStatsService;
        this.wishlistService = wishlistService;
        this.pagesViewCountService = pagesViewCountService;
        this.categoryRepository = categoryRepository;
        this.reviewService = reviewService;
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
                              @AuthenticationPrincipal UserDetails principal) throws ObjectNotFoundException, IOException {

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

        redirectAttributes.addFlashAttribute("addedSuccessfully", true);
        return "redirect:/books/" + bookId; //TODO add bookId
    }

    @GetMapping("/{id}")
    public String details(@PathVariable Long id,
                          Model model) throws ObjectNotFoundException {

        BookDetailViewModel bookDetailViewModel = bookService.findBookDetails(id)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_BOOK));

        model.addAttribute("book", bookDetailViewModel);
        model.addAttribute("viewsCount", pagesViewCountService.getPageViewsCount(String.format(VIEWS_COUNT_URI, id)));

        return "book-details";
    }

    @PreAuthorize("isAdmin()")
    @PatchMapping("/edit/{id}")
    public String editConfirm(@PathVariable Long id,
                              @Valid BookUpdateBindingModel bookUpdateBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) throws ObjectNotFoundException, IOException {
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("bookUpdateBindingModel", bookUpdateBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.bookUpdateBindingModel", bindingResult);

            return "redirect:/book/edit" + id + "/errors";
        }

        BookUpdateServiceModel updateServiceModel = modelMapper
                .map(bookUpdateBindingModel, BookUpdateServiceModel.class);
        updateServiceModel.setId(id);

        bookService.update(updateServiceModel);

        redirectAttributes.addFlashAttribute("updatedSuccessfully", true);
        return "redirect:/books/" + id;
    }

    @PreAuthorize("isAdmin()")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ObjectNotFoundException {
        wishlistService.deleteBookFromAllWishlist(id);
        shoppingCartService.deleteBookFromAllShoppingCarts(id);
        reviewService.deleteAllReviewsForBook(id);
        bookService.delete(id);
        return "redirect:/books/all";
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
