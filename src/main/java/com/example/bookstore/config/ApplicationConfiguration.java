package com.example.bookstore.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    private final CloudConfiguration cloudConfiguration;


    public ApplicationConfiguration(CloudConfiguration cloudConfiguration) {
        this.cloudConfiguration = cloudConfiguration;
    }

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                Map.of(
                        "cloud_name",cloudConfiguration.getCloudName(),
                        "api_key",cloudConfiguration.getApiKey(),
                        "api_secret",cloudConfiguration.getApiSecret()
                )
        );
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }
}
