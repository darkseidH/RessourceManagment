package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/responsable")
@PreAuthorize("hasRole('ROLE_RESPONSABLE')")
public class ResponsableController {
    private static final String USER_OBJECT = "user";

    @GetMapping("/responsable")
    public String getHomeResponsable(Model model, @AuthenticationPrincipal User userDetails) {
        model.addAttribute(USER_OBJECT, userDetails);
        return "responsable/home";
    }
}
