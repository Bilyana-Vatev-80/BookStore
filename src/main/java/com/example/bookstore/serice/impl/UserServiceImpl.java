package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.UserEntity;
import com.example.bookstore.model.entity.UserRoleEntity;
import com.example.bookstore.model.entity.enums.UserRoleEnum;
import com.example.bookstore.model.service.UserLoginServiceModel;
import com.example.bookstore.model.service.UserRegisterServiceModel;
import com.example.bookstore.model.view.UserViewModel;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.serice.UserService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bookstore.constant.GlobalConstants.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final BookstoreUserService bookstoreUserService;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, BookstoreUserService bookstoreUserService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.bookstoreUserService = bookstoreUserService;
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUsernameIgnoreCase(username)
                .isPresent();
    }

    @Override
    public void register(UserRegisterServiceModel userRegisterServiceModel) throws ObjectNotFoundException {
        UserEntity newUser = modelMapper
                .map(userRegisterServiceModel, UserEntity.class);

        newUser.setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRoleEnum.USER)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER_ROLE));

        newUser.addRole(userRole);

        userRepository.save(newUser);

    }

    @Override
    public void login(UserLoginServiceModel loginServiceModel) {
        UserDetails principal = bookstoreUserService.loadUserByUsername(loginServiceModel.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, loginServiceModel.getPassword(),
                principal.getAuthorities());

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
    }

    @Override
    public Optional<UserViewModel> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userEntity -> modelMapper.map(userEntity, UserViewModel.class));
    }

    @Override
    public List<String> findAllUsername() {
        return userRepository.findAllByUsername();
    }

}
