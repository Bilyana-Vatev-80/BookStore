package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.*;
import com.example.bookstore.model.entity.enums.CategoryEnum;
import com.example.bookstore.model.entity.enums.LanguageEnum;
import com.example.bookstore.model.service.BookAddServiceModel;
import com.example.bookstore.model.view.BookSummaryViewModel;
import com.example.bookstore.repository.*;
import com.example.bookstore.serice.BookService;
import com.example.bookstore.serice.cloudinary.CloudinaryImage;
import com.example.bookstore.serice.cloudinary.CloudinaryService;
import com.example.bookstore.util.DataUtils;
import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.bookstore.constant.GlobalConstants.*;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;
    private final CategoryRepository categoryRepository;
    private final PublishingHouseRepository publishingHouseRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;


    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, PictureRepository pictureRepository, CloudinaryService cloudinaryService, CategoryRepository categoryRepository, PublishingHouseRepository publishingHouseRepository, AuthorRepository authorRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
        this.categoryRepository = categoryRepository;
        this.publishingHouseRepository = publishingHouseRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
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

    @Transactional
    @Override
    public List<BookSummaryViewModel> findAllBooks() {
        return bookRepository.findAllByActiveTrueOrderByAddedOnDesc()
                .stream()
                .map(this::getSummaryViewModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<BookSummaryViewModel> findAllBooksOrderByTitle() {
        return bookRepository.findAllByActiveTrueOrderByTitleAscAddedOnDesc()
                .stream()
                .map(this::getSummaryViewModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<BookSummaryViewModel> findAllBooksOrderByAuthor() {
        return bookRepository.findAllByActiveTrueOrderByAuthor()
                .stream()
                .map(this::getSummaryViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookSummaryViewModel> findAllBooksByOrderByBestSelling() {
        return bookRepository.findAllByActiveTrueOrderByBestSelling()
                .stream()
                .map(this::getSummaryViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public Long add(BookAddServiceModel bookAddServiceModel) throws IOException, ObjectNotFoundException {

        MultipartFile img = bookAddServiceModel.getImage();

        BookEntity bookEntity = modelMapper
                .map(bookAddServiceModel, BookEntity.class)
                .setActive(true)
                .setPicture(getPictureEntity(img))
                .setLanguage(getLanguageEnum(bookAddServiceModel.getLanguage()))
                .setCategories(getCategoryEntities(bookAddServiceModel.getCategories()))
                .setPublishingHouse(getPublishingHouseEntity(bookAddServiceModel.getPublishingHouse()))
                .setAuthor(getAuthorEntity(bookAddServiceModel.getAuthorFirstName(),
                                            bookAddServiceModel.getAuthorLastName()))
                .setCreator(getUserEntity(bookAddServiceModel.getCreator()));

        bookEntity = bookRepository.save(bookEntity);

        return bookEntity.getId();
    }


    private UserEntity getUserEntity(String username) throws ObjectNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER));
    }

    private AuthorEntity getAuthorEntity(String authorFirstName, String authorLastName) {
        return authorRepository.findByFirstNameAndLastName(authorFirstName, authorLastName)
                .orElseGet(() ->{
                    AuthorEntity author = new AuthorEntity()
                            .setFirstName(authorFirstName)
                            .setLastName(authorLastName)
                            .setPicture(pictureRepository.save(new PictureEntity(DEFAULT_AUTHOR_IMAGE_URL)));

                    return authorRepository.save(author);
                });
    }

    private PublishingHouseEntity getPublishingHouseEntity(String publishingHouseName) throws ObjectNotFoundException {
        return publishingHouseRepository.findByName(publishingHouseName)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_PUBLISHING_HOUSE));
    }

    private List<CategoryEntity> getCategoryEntities(List<String> categories) {
        return categories
                .stream()
                .map(category -> {
                    CategoryEnum categoryEnum = CategoryEnum.valueOf(
                            category.toUpperCase().replaceAll(" ", "_"));

                    CategoryEntity categoryEntity = null;
                    try {
                        categoryEntity = categoryRepository
                                .findByCategory(categoryEnum)
                                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_CATEGORY));
                    } catch (ObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                    return categoryEntity;
                })
                .collect(Collectors.toList());
    }


    private LanguageEnum getLanguageEnum(String language) {
        return LanguageEnum.valueOf(language.toUpperCase());
    }


    private PictureEntity getPictureEntity(MultipartFile img) throws IOException {
        if(!"".equals(img.getOriginalFilename())){
            final CloudinaryImage uploaded = cloudinaryService.upload(img);
            return pictureRepository.save(new PictureEntity()
                    .setUrl(uploaded.getUrl())
                    .setPublicId(uploaded.getPublicId()));
        } else {
            return pictureRepository.save(new PictureEntity(DEFAULT_BOOK_IMAGE_URL));
        }

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
