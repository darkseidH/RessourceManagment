package com.ressourcemanagement.controller;


import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.DepartementService;
import com.ressourcemanagement.service.EnseignantService;
import com.ressourcemanagement.service.ImprimanteService;
import com.ressourcemanagement.service.OrdinateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/enseignant")
@PreAuthorize("hasRole('ROLE_ENSEIGNANT')")
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

    // kant
    @GetMapping("/enseignant")
    public String getHomeEnseignant(Model model, @AuthenticationPrincipal User user) {
        Long id = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(id);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(id);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }


    @GetMapping("/enseignant/ajouterNewRessource")
    public String NewRessource(Model model, @AuthenticationPrincipal User user) {
        String userName = user.getUsername();
        model.addAttribute(USER_OBJECT, user);
        Ordinateur ordinateur = new Ordinateur();
        model.addAttribute("ordinateur", ordinateur);
        Imprimante imprimante = new Imprimante();
        model.addAttribute("imprimante", imprimante);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        return "enseignant/ajouterNewRessource"; // Adjusted template name
    }

    @PostMapping("/enseignant/saveImprimante") //saveRessourceMaterielle
    public String saveImprimante(@AuthenticationPrincipal User user, @ModelAttribute("imprimante") Imprimante imprimante, Model model, @RequestParam(name = "departementUsage", required = false) String departementUsage) {
        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
        imprimante.setEnseignant(enseignant);
        if (departementUsage != null) {
            if (departementUsage.equals("oui")) {
                Departement departement = departementService.findDepartementByIdChef(user.getId());
                imprimante.setDepartement(departement);
            }
        }
        imprimante.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        imprimanteService.saveImprimante(imprimante);
        Long id = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(id);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(id);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }


    @PostMapping("/enseignant/saveOrdinateur") //saveRessourceMaterielle
    public String saveOrdinateur(@AuthenticationPrincipal User user, @ModelAttribute("ordinateur") Ordinateur ordinateur, Model model, @RequestParam(name = "departementUsage", required = false) String departementUsage) {
        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
        if (departementUsage != null) {
            if (departementUsage.equals("oui")) {
                Departement departement = departementService.findDepartementByIdChef(user.getId());
                ordinateur.setDepartement(departement);
            }
        }
        ordinateur.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        ordinateur.setEnseignant(enseignant);
        ordinateurService.saveOrdinateur(ordinateur);
        Long id = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(id);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(id);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }

    @GetMapping("/enseignant/ordinateur/{id}/delete")
    public String deleteOrdinateur(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        ordinateurService.deleteOrdinateur(id);
        Long userId = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(userId);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(userId);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }

    @GetMapping("/enseignant/imprimante/{id}/delete")
    public String deleteImprimante(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        imprimanteService.deleteImprimante(id);
        Long userId = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(userId);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(userId);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }

    @GetMapping("/enseignant/RessourcesEnseignant")
    public String getRessourcesEnseignant(Model model, @AuthenticationPrincipal User user) {
        Long id = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantAffecterEnsignant(id);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(id);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/RessourcesEnseignant";
    }

    @GetMapping("/enseignant/ordinateur/{id}/edit")
    public String editOrdinateur(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Ordinateur ordinateur = ordinateurService.getOrdinateurById(id);
        model.addAttribute("ordinateur", ordinateur);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/editOrdinateur";
    }

    @GetMapping("/enseignant/imprimante/{id}/edit")
    public String editImprimante(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Imprimante imprimante = imprimanteService.getImprimanteById(id);
        model.addAttribute("imprimante", imprimante);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/editImprimante";
    }

    @PostMapping("/enseignant/imprimante/{id}/edit")
    public String updateImprimante(@PathVariable("id") long id, @ModelAttribute("imprimante") Imprimante imprimante, Model model, @AuthenticationPrincipal User user) {
        imprimante.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        imprimanteService.updateImprimante(imprimante);
        Long userId = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(userId);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(userId);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }

    @PostMapping("/enseignant/ordinateur/{id}/edit")
    public String updateOrdinateur(@PathVariable("id") long id, @ModelAttribute("ordinateur") Ordinateur ordinateur, Model model, @AuthenticationPrincipal User user) {
        ordinateur.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        ordinateurService.updateOrdinateur(ordinateur);
        Long userId = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(userId);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(userId);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }


}
