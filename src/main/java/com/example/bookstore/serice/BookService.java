package com.example.bookstore.serice;

import com.example.bookstore.model.service.BookAddServiceModel;
import com.example.bookstore.model.view.BookSummaryViewModel;

import java.io.IOException;
import java.util.List;

public interface BookService {

    boolean existsByIsbn(String isbn);

    List<BookSummaryViewModel> findBooksByAuthor(Long id);

    List<BookSummaryViewModel> findAllBooks();

    List<BookSummaryViewModel> findAllBooksOrderByTitle();

    List<BookSummaryViewModel> findAllBooksOrderByAuthor();

    List<BookSummaryViewModel> findAllBooksByOrderByBestSelling();

    Long add(BookAddServiceModel bookAddServiceModel) throws IOException;
}


