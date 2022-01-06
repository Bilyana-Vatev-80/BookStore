package com.example.bookstore.web;

import com.example.bookstore.serice.BookService;
import com.example.bookstore.serice.PublishingHouseService;
import com.example.bookstore.serice.RequestsStatsService;
import com.example.bookstore.serice.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;
    private final PublishingHouseService publishingHouseService;
    private final ShoppingCartService shoppingCartService;
    private final RequestsStatsService requestsStatsService;


    public BookController(BookService bookService, ModelMapper modelMapper, PublishingHouseService publishingHouseService, ShoppingCartService shoppingCartService, RequestsStatsService requestsStatsService) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.publishingHouseService = publishingHouseService;
        this.shoppingCartService = shoppingCartService;
        this.requestsStatsService = requestsStatsService;
    }
}
