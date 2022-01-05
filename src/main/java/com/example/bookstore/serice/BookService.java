package com.example.bookstore.serice;

import com.example.bookstore.model.view.BookSummaryViewModel;

import java.util.List;

public interface BookService {

    boolean existsByIsbn(String isbn);

    List<BookSummaryViewModel> findBooksByAuthor(Long id);
}


