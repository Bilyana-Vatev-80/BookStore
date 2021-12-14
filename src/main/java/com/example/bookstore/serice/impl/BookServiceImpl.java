package com.example.bookstore.serice.impl;

import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.serice.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }
}
