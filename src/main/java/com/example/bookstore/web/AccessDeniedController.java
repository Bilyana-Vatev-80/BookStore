package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "errors/unauthorized-error";
    }
}
