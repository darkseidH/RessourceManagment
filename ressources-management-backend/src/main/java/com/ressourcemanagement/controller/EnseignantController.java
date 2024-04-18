package com.ressourcemanagement.controller;


import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/enseignant")
@AllArgsConstructor
public class EnseignantController {
    private static final String USER_OBJECT = "user";
    @Autowired
    private DepartementService departementService;

    @GetMapping("/enseignant")
    public String getHomeEnseignant(Model model, @AuthenticationPrincipal User user) {
//        String userName = userDetails.getUsername();
        Long id = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(id);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }
}
