package com.ressourcemanagement.service;

import com.ressourcemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
            User user;
            user = loadedUser;
            user.setNotifications(null);
            return user;
        }
    }
}
