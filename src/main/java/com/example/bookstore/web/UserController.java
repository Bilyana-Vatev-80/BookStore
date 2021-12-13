package com.example.bookstore.web;

import com.example.bookstore.model.binding.UserLoginBindingModel;
import com.example.bookstore.model.binding.UserRegisterBindingModel;
import com.example.bookstore.model.service.UserLoginServiceModel;
import com.example.bookstore.model.service.UserRegisterServiceModel;
import com.example.bookstore.model.view.UserViewModel;
import com.example.bookstore.serice.OrderService;
import com.example.bookstore.serice.UserService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static com.example.bookstore.constant.GlobalConstants.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, OrderService orderService, ModelMapper modelMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:/users/register";
        }

        UserRegisterServiceModel userRegisterServiceModel = modelMapper
                .map(userRegisterBindingModel, UserRegisterServiceModel.class);

        userService.register(userRegisterServiceModel);

        return "redirect:/users/login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel){

        userService.login(modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));

        return "redirect:/books/all";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                              String username,RedirectAttributes redirectAttributes){

        redirectAttributes
                .addFlashAttribute("badCredential", true)
                .addFlashAttribute("username", username);

        return "redirect:/logon";
    }

    @GetMapping("/profile")
    public String showProfile(Model model,
                              @AuthenticationPrincipal UserDetails principal) throws ObjectNotFoundException {

        UserViewModel userViewModel = userService.findByUsername(principal.getUsername())
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER));

        model.addAttribute("user", userViewModel);

        return "profile";
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }
}
