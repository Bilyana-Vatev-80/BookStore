package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.BookEntity;
import com.example.bookstore.model.view.BookDetailViewModel;
import com.example.bookstore.model.view.BookSummaryViewModel;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.serice.BookService;
import com.example.bookstore.util.DataUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

    @Transactional
    @Override
    public List<BookSummaryViewModel> findBooksByAuthor(Long id) {
        return bookRepository
                .findAllByActiveTrueAndAuthorIdOrderByAddedOnDesc(id)
                .stream()
                .map(this::getSummaryViewModel)
                .collect(Collectors.toList());
    }

   private BookSummaryViewModel getSummaryViewModel(BookEntity bookEntity){
       return modelMapper
               .map(bookEntity, BookSummaryViewModel.class)
               .setCategories(DataUtils.getCategories(bookEntity.getCategories()))
               .setAuthor(DataUtils.getFullName(
                       bookEntity.getAuthor().getFirstName(),
                       bookEntity.getAuthor().getLastName()))
               .setAuthorId(bookEntity.getAuthor().getId());
   }
}
