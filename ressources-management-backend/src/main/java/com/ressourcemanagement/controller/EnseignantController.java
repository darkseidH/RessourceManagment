package com.ressourcemanagement.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/enseignant")
public class EnseignantController {
    private static final String USER_OBJECT = "user";

    @GetMapping("/enseignant")
    public String getHomeEnseignant(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String userName = userDetails.getUsername();
        model.addAttribute(USER_OBJECT, userDetails);
        return "enseignant/home";
    }
}
