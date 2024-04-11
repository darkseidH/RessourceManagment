package com.ressourcemanagement.controller;


import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDto) {
        System.out.println(userDto.toString());
        userService.register(userDto);
        return "redirect:/login?success";
    }
}
