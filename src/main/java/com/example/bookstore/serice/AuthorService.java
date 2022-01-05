package com.example.bookstore.serice;

import com.example.bookstore.model.service.AuthorAddServiceModel;
import com.example.bookstore.model.view.AuthorViewModel;

import java.io.IOException;
import java.util.Optional;

public interface AuthorService {
    Long add(AuthorAddServiceModel authorAddServiceModel) throws IOException;

   Optional<AuthorViewModel> findById(Long id);
}
