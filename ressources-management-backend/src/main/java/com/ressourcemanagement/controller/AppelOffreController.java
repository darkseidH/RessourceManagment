package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.RessourceMaterielle;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_RESPONSABLE')")
public class AppelOffreController {
    @Autowired
    private AppelOffreService appelOffreService;

    @GetMapping("/responsable/appel-offres")
    public String getAllAppelOffres(Model model, @AuthenticationPrincipal User user) {
        List<AppelOffre> appelOffres = appelOffreService.getAllAppelOffres();
        model.addAttribute("user", user);
        model.addAttribute("appelOffres", appelOffres);
        return "responsable/appel-offres/appels-offres";
    }

    @GetMapping("/responsable/appel-offres/{id}/content")
    public String getAllAppelOffreRessources(Model model, @PathVariable("id") long id, @AuthenticationPrincipal User user) {
        AppelOffre appelOffre = appelOffreService.getAppelOffreById(id);
        List<RessourceMaterielle> ressourceMaterielles = appelOffreService.getAppelOffreById(id).getRessources();
        model.addAttribute("appelOffre", appelOffre);
        model.addAttribute("listesRessources", ressourceMaterielles);
        model.addAttribute("user", user);
        return "responsable/appel-offres/show-ressources";
    }


}
