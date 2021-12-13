package com.example.bookstore.serice.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    CloudinaryImage upload(MultipartFile multipartFile) throws IOException;
    void delete(String publicId);
}
