package com.ressourcemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var loadedUser = userService.findByEmail(email);
        if (loadedUser == null) {
            return null;
        } else {
            return User.builder().username(loadedUser.getEmail()).password(loadedUser.getPassword()).roles(loadedUser.getRole()).build();
        }
    }
}
