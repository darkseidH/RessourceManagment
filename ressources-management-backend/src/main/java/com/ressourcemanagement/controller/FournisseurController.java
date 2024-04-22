package com.ressourcemanagement.controller;


import com.ressourcemanagement.dto.SoumissionDTO;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.AppelOffreService;
import com.ressourcemanagement.service.FournisseurService;
import com.ressourcemanagement.service.SoumissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("/fournisseur")
@PreAuthorize("hasRole('ROLE_FOURNISSEUR')")
public class FournisseurController {
    private static final String USER_OBJECT = "user";
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private AppelOffreService appelOffreService;
    @Autowired
    private SoumissionService soumissionService;

    @GetMapping("/fournisseur")
    public String getHomeFournisseur(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute(USER_OBJECT, user);
        return "/fournisseur/home";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping("/add")
    public String addUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "fournisseur/creercompte";
    }

    @GetMapping("/fournisseur/appels-offres")
    public String getAllAppelOffres(Model model, @AuthenticationPrincipal User user) {
        List<AppelOffre> appelOffreList = fournisseurService.getAllAppleOffre();
        List<AppelOffre> filtredList = appelOffreList.stream().filter(appelOffre -> appelOffre.getDateFin().after(new Date())).toList();
        model.addAttribute("filtredList", filtredList);
        model.addAttribute("user", user);
        return "fournisseur/appels-offres";
    }

    @GetMapping("/fournisseur/appels-offres/{id}/soumission")
    public String getappelOffreDetails(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal User user) {
        AppelOffre appelOffreDetails = appelOffreService.getAppelOffreById(id);
        if (appelOffreDetails == null) {
            return "error/404";
        }
        List<RessourceMaterielle> listeOrdinateurs = appelOffreDetails.getRessources().stream()
                .filter(ordinateur -> ordinateur instanceof Ordinateur &&
                        ordinateur.getSoumissions().stream().noneMatch(soumission -> soumission.getFournisseur().getId().equals(user.getId()))
                ).toList();
        List<RessourceMaterielle> listeImprimantes =
                appelOffreDetails.getRessources().stream().filter(imprimante -> imprimante instanceof Imprimante &&
                        imprimante.getSoumissions().stream().noneMatch(soumission -> soumission.getFournisseur().getId().equals(user.getId()))
                ).toList();

        model.addAttribute("listeOrdinateurs", listeOrdinateurs);
        model.addAttribute("listeImprimantes", listeImprimantes);
        model.addAttribute("appeloffre", appelOffreDetails);
        model.addAttribute("user", user);
        return "fournisseur/soumission";
    }

    @PostMapping("/fournisseur/soumission/{id}")
    public String addSoumission(@PathVariable("id") Long id, @ModelAttribute("soumission") List<Soumission> soumissions, Model model, @AuthenticationPrincipal User user) {
        for (Soumission soumission : soumissions) {
            fournisseurService.saveSoumission(soumission);
        }
        return "redirect:/fournisseur/soumission/{id}?success";
    }

    @PostMapping("/fournisseur/soumission/add")
    public ResponseEntity<String> addSoumission(@ModelAttribute("soumission") SoumissionDTO soumission, @AuthenticationPrincipal User user) {
        soumissionService.saveSoumission(soumission, user.getId());
        return ResponseEntity.ok("Soumission Validé");

    }


}
