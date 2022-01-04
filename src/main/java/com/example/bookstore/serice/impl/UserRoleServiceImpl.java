package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.UserEntity;
import com.example.bookstore.model.entity.UserRoleEntity;
import com.example.bookstore.model.entity.enums.UserRoleEnum;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.serice.UserRoleService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.bookstore.constant.GlobalConstants.*;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void assignUserRole(String username, UserRoleEnum roleEnum) throws ObjectNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER));

        UserRoleEntity roleEntity = userRoleRepository.findByRole(roleEnum)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER_ROLE));

        userEntity.addRole(roleEntity);
        userRepository.save(userEntity);
    }
}
