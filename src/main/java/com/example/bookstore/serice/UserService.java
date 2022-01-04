package com.example.bookstore.serice;

import com.example.bookstore.model.service.UserLoginServiceModel;
import com.example.bookstore.model.service.UserRegisterServiceModel;
import com.example.bookstore.model.view.UserViewModel;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean usernameExists(String username);

    void register(UserRegisterServiceModel userRegisterServiceModel) throws ObjectNotFoundException;

    void login(UserLoginServiceModel loginServiceModel);

    Optional<UserViewModel> findByUsername(String username);

    List<String> findAllUsername();

}
