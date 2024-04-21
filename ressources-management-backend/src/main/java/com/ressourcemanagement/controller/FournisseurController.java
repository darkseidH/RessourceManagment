package com.ressourcemanagement.controller;


import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.model.Soumission;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller("/fournisseur")
@PreAuthorize("hasRole('ROLE_FOURNISSEUR')")
public class FournisseurController {
    private static final String USER_OBJECT = "user";
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/fournisseur")
    public String getHomeFournisseur(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute(USER_OBJECT, user);
        return "/fournisseur/home";
    }

    @PostMapping("/add")
    public String addUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "fournisseur/creercompte";
    }

    @GetMapping("/fournisseur/apples-offres")
    public String getAllAppelOffres(Model model, @AuthenticationPrincipal User user) {
        List<AppelOffre> appelOffreList = fournisseurService.getAllAppleOffre();
        List<AppelOffre> filtredList = appelOffreList.stream().filter(appelOffre -> appelOffre.getDateFin().after(new Date())).toList();
        model.addAttribute("filtredList", filtredList);
        model.addAttribute("user", user);
        return "fournisseur/appels-offres";
    }

    @PostMapping("/fournisseur/soumission")
    public String addSoumission(Model model, @ModelAttribute("soumission") Soumission soumission, @AuthenticationPrincipal User user) {
        Fournisseur fournisseur = fournisseurService.getFournissuerByEmail(user.getEmail());
        soumission.setFournisseur(fournisseur);
        model.addAttribute("soumission", soumission);
        model.addAttribute("user", user);
        return "fournisseur/soumission?success";
    }


}
