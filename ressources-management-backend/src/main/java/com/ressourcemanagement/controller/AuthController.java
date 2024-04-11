package com.ressourcemanagement.controller;


import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/")
    public String getHomePage(Authentication authentication) {
        String homePage = "home";

        if (authentication != null && authentication.isAuthenticated()) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (authority.getAuthority().equals("ENSEIGNANT")) {
                    homePage = "redirect:/enseignant";
                    break;
                } else if (authority.getAuthority().equals("RESPONSABLE")) {
                    homePage = "redirect:/responsable";
                    break;
                } else if (authority.getAuthority().equals("TECHNICIEN")) {
                    homePage = "redirect:/technicien";
                    break;

                }
            }
        }
        return homePage;
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
