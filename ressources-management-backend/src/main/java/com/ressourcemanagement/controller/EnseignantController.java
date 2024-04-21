package com.ressourcemanagement.controller;


import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.DepartementService;
import com.ressourcemanagement.service.EnseignantService;
import com.ressourcemanagement.service.ImprimanteService;
import com.ressourcemanagement.service.OrdinateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/enseignant")
@AllArgsConstructor
public class EnseignantController {
    private static final String USER_OBJECT = "user";
    @Autowired
    private DepartementService departementService;
    @Autowired
    private OrdinateurService ordinateurService;
    @Autowired
    private ImprimanteService imprimanteService;
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping("/enseignant")
    public String getHomeEnseignant(Model model, @AuthenticationPrincipal User user) {
        Long id = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(id);
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }




}
