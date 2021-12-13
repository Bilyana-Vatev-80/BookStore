package com.example.bookstore.serice.cloudinary.impl;

import com.cloudinary.Cloudinary;
import com.example.bookstore.serice.cloudinary.CloudinaryImage;
import com.example.bookstore.serice.cloudinary.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public CloudinaryImage upload(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile(TEMP_FILE,multipartFile.getOriginalFilename());
        multipartFile.transferTo(tempFile);

        try {
            @SuppressWarnings("unchecked")
            Map<String, String> uploadResult = cloudinary
                    .uploader()
                    .upload(tempFile, Collections.emptyMap());

            String url = uploadResult.getOrDefault(URL, "https://cdn.dribbble.com/users/34642/screenshots/1890926/media/c7c3051baa6199482fbd63599dd635b0.jpg");
            String publicId = uploadResult.getOrDefault(PUBLIC_ID,"");

            return new CloudinaryImage()
                    .setUrl(url)
                    .setPublicId(publicId);
        } finally {
            tempFile.delete();
        }

    }

    @Override
    public void delete(String publicId) {
        try {
            this.cloudinary.uploader().destroy(publicId, Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
