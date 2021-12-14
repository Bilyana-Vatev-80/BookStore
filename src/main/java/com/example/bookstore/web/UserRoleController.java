package com.example.bookstore.web;


import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.serice.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserRoleController {

    private final UserRoleRepository userRoleRepository;
    private final UserService userService;

    public UserRoleController(UserRoleRepository userRoleRepository, UserService userService) {
        this.userRoleRepository = userRoleRepository;
        this.userService = userService;
    }

    @GetMapping("/assign")
    public String assign(Model model){
        return "assign-role";
    }
}
