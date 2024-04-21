package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class TechnicienController {

    private TechnicienService technicienService;
    private PanneService panneService;
    private static final String USER_OBJECT = "user";
    @Autowired
    private DepartementService departementService;
    @Autowired
    private OrdinateurService ordinateurService;
    @Autowired
    private ImprimanteService imprimanteService;
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping("/technicien")
    public String getHomeTechnicien(Model model, @AuthenticationPrincipal User user) {
        Long id = user.getId();

//        List<Panne> panne = technicienService.getAllPanne();
//        model.addAttribute("Panne",panne);

        model.addAttribute(USER_OBJECT, user);
        return "technicien/home";
    }


}
