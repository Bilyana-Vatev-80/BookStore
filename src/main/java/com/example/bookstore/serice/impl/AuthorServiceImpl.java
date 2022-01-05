package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.AuthorEntity;
import com.example.bookstore.model.entity.PictureEntity;
import com.example.bookstore.model.service.AuthorAddServiceModel;
import com.example.bookstore.model.view.AuthorViewModel;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.PictureRepository;
import com.example.bookstore.serice.AuthorService;
import com.example.bookstore.serice.cloudinary.CloudinaryImage;
import com.example.bookstore.serice.cloudinary.CloudinaryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static com.example.bookstore.constant.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, PictureRepository pictureRepository, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long add(AuthorAddServiceModel authorAddServiceModel) throws IOException {

        MultipartFile img = authorAddServiceModel.getImage();

        AuthorEntity authorEntity = modelMapper.map(authorAddServiceModel, AuthorEntity.class)
                .setPicture(getPictureEntity(img));
        return null;
    }

    @Override
    public Optional<AuthorViewModel> findById(Long id) {
        return authorRepository.findById(id)
                .map(authorEntity -> modelMapper.map(authorEntity, AuthorViewModel.class));
    }

    private PictureEntity getPictureEntity(MultipartFile img) throws IOException {
        if(!"".equals(img.getOriginalFilename())){
            final CloudinaryImage uploaded = cloudinaryService.upload(img);
            return pictureRepository.save(new PictureEntity()
                    .setUrl(uploaded.getUrl())
                    .setPublicId(uploaded.getPublicId()));
        } else {
            return pictureRepository.save(new PictureEntity(DEFAULT_AUTHOR_IMAGE_URL));
        }
    }
}
