package com.example.bookstore.web;

import com.example.bookstore.model.binding.BookAddBindingModel;
import com.example.bookstore.model.binding.BookUpdateBindingModel;
import com.example.bookstore.serice.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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


    public BookController(BookService bookService, ModelMapper modelMapper, PublishingHouseService publishingHouseService, ShoppingCartService shoppingCartService, RequestsStatsService requestsStatsService, WishlistService wishlistService, PagesViewCountService pagesViewCountService) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.publishingHouseService = publishingHouseService;
        this.shoppingCartService = shoppingCartService;
        this.requestsStatsService = requestsStatsService;
        this.wishlistService = wishlistService;
        this.pagesViewCountService = pagesViewCountService;
    }

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

    @ModelAttribute("bookUpdateBindingModel")
    public BookUpdateBindingModel bookUpdateBindingModel(){
        return new BookUpdateBindingModel();
    }

    @ModelAttribute("bookAddBindingModel")
    public BookAddBindingModel bookAddBindingModel(){
        return new BookAddBindingModel();
    }
}
