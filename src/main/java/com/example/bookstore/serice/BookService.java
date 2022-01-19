package com.example.bookstore.serice;

import com.example.bookstore.model.binding.BookUpdateBindingModel;
import com.example.bookstore.model.service.BookAddServiceModel;
import com.example.bookstore.model.service.BookUpdateServiceModel;
import com.example.bookstore.model.view.BookDetailViewModel;
import com.example.bookstore.model.view.BookSummaryViewModel;
import javassist.tools.rmi.ObjectNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookService {

    boolean existsByIsbn(String isbn);

    List<BookSummaryViewModel> findBooksByAuthor(Long id);

    List<BookSummaryViewModel> findAllBooks();

    List<BookSummaryViewModel> findAllBooksOrderByTitle();

    List<BookSummaryViewModel> findAllBooksOrderByAuthor();

    List<BookSummaryViewModel> findAllBooksByOrderByBestSelling();

    Long add(BookAddServiceModel bookAddServiceModel) throws IOException, ObjectNotFoundException;

    Optional<BookDetailViewModel> findBookDetails(Long id);

    Optional<BookUpdateBindingModel> findBookToEdit(Long id);

    Long update(BookUpdateServiceModel bookUpdateServiceModel) throws ObjectNotFoundException, IOException;

    void delete(Long id) throws ObjectNotFoundException;

    boolean exitsByIsbn(String isbn);

    void increaseWithOneCopy(Long id) throws ObjectNotFoundException;

    void decreaseWithOneCopy(Long id) throws ObjectNotFoundException;

    List<String> findAllBookTitlesWithTwoOrLessCopies();

    Map<String, Integer> getBookCategoriesMap() throws ObjectNotFoundException;
}


