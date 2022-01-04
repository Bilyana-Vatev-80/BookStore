package com.example.bookstore.web;


import com.example.bookstore.model.entity.enums.UserRoleEnum;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.serice.UserRoleService;
import com.example.bookstore.serice.UserService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;
    private final UserService userService;

    public UserRoleController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/assign")
    public String assign(Model model){
        model.addAttribute("usernames",userService.findAllUsername());
        return "assign-role";
    }

    @PostMapping("/assign")
    public String assignUserRole(@RequestParam String username,
                                 @RequestParam String role) throws ObjectNotFoundException {

        userRoleService.assignUserRole(username, UserRoleEnum.valueOf(role.toUpperCase()));
        return "redirect:/books/all";
    }
}
