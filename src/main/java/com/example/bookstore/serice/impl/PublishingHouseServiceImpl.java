package com.example.bookstore.serice.impl;

import com.example.bookstore.repository.PublishingHouseRepository;
import com.example.bookstore.serice.PublishingHouseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseRepository publishingHouseRepository;
    private final ModelMapper modelMapper;

    public PublishingHouseServiceImpl(PublishingHouseRepository publishingHouseRepository, ModelMapper modelMapper) {
        this.publishingHouseRepository = publishingHouseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<String> findAllPublishingHouseNames() {
        return publishingHouseRepository.findAllPublishingHouseNames();
    }
}
