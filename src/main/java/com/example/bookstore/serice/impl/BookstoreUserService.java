package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.UserEntity;
import com.example.bookstore.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.bookstore.constant.GlobalConstants.*;

@Component
public class BookstoreUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public BookstoreUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_ERROR_MESSAGE, username)));

        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        List<GrantedAuthority> authorities = userEntity
                .getRoles()
                .stream()
                .map(a -> new SimpleGrantedAuthority("ROLE_" + a.getRole().name()))
                .collect(Collectors.toList());

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
    }
}
