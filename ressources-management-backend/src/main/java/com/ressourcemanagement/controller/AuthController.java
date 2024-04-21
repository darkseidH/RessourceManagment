package com.ressourcemanagement.controller;


import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
                if (authority.getAuthority().equals("ROLE_ENSEIGNANT")) {
                    homePage = "redirect:/enseignant";
                    break;
                } else if (authority.getAuthority().equals("ROLE_RESPONSABLE")) {
                    homePage = "redirect:/responsable";
                    break;
                } else if (authority.getAuthority().equals("ROLE_TECHNICIEN")) {
                    homePage = "redirect:/technicien";
                    break;
                } else if (authority.getAuthority().equals("ROLE_FOURNISSEUR")) {
                    homePage = "redirect:/fournisseur";
                } else {
                    homePage = "redirect:/login";
                }
            }
        }
        return homePage;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register-fournisseur")
    public String getRegistration(Model model) {
        UserDto user_to_add = new UserDto();
        model.addAttribute("user_to_add", user_to_add);
        return "registration";
    }

    @PostMapping("/register-fournisseur")
    public String registerUser(UserDto userDto) {
        System.out.println(userDto.toString());
        userService.register(userDto);
        return "redirect:/login?success";
    }
}
