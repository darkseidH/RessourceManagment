package com.ressourcemanagement.controller;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.DepartementService;
import com.ressourcemanagement.service.EnseignantService;
import com.ressourcemanagement.service.ImprimanteService;
import com.ressourcemanagement.service.OrdinateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class chefDepartementController {
    private static final String USER_OBJECT = "user";
    @Autowired
    private DepartementService departementService;
    @Autowired
    private OrdinateurService ordinateurService;
    @Autowired
    private ImprimanteService imprimanteService;
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping("/chefDepartement/besionsDepartement")
    public String getBesionsDepartement(Model model, @AuthenticationPrincipal User user) {
        Long id = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        Departement departement = departementService.findDepartementByIdChef(id);
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/BesionsChefDepartement";
    }

    @GetMapping("/chefDepartement/ordinateur/{id}/edit")
    public String editOrdinateur(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Ordinateur ordinateur = ordinateurService.getOrdinateurById(id);
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("enseignants", enseignants);
        model.addAttribute(USER_OBJECT, user);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        return "chefDepartement/editOrdinateur";
    }


    @PostMapping("/chefDepartement/ordinateur/{id}/edit")
    public String handleFormSubmission(@PathVariable("id") long id, @ModelAttribute("ordinateur") Ordinateur ordinateur, @RequestParam("departementUtilise") boolean departementUtilise, BindingResult result, Model model, @AuthenticationPrincipal User user) {
        Long idchef = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute(USER_OBJECT, user);
        if (departementUtilise) {
            Departement departement = departementService.findDepartementByIdChef(idchef);
            ordinateur.setDepartement(departement);
        } else {
            ordinateur.setDepartement(null);
        }
        ordinateur.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        ordinateurService.updateOrdinateur(ordinateur);

        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/BesionsChefDepartement";
    }

    // Imprimante

    @GetMapping("/chefDepartement/imprimante/{id}/delete")
    public String deleteImprimante(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        imprimanteService.deleteImprimante(id);
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/BesionsChefDepartement";
    }

    @GetMapping("/chefDepartement/ordinateur/{id}/delete")
    public String deleteOrdinateur(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        ordinateurService.deleteOrdinateur(id);
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/BesionsChefDepartement";
    }


    @GetMapping("/chefDepartement/imprimante/{id}/edit")
    public String editImprimante(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Long idChef = user.getId();
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        Imprimante imprimante = imprimanteService.getImprimanteById(id);
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        boolean isChef = departementService.getDebartementbyIdChef(id);
        model.addAttribute("isChef", isChef);
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("enseignants", enseignants);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/editImprimante";
    }

    @PostMapping("/chefDepartement/imprimante/{id}/edit")
    public String handleFormSubmission(@PathVariable("id") long id, @ModelAttribute("imprimante") Imprimante imprimante, @RequestParam("departementUtilise") boolean departementUtilise, BindingResult result, Model model, @AuthenticationPrincipal User user) {
        Long idchef = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute(USER_OBJECT, user);
        if (departementUtilise) {
            Departement departement = departementService.findDepartementByIdChef(idchef);
            imprimante.setDepartement(departement);
        } else {
            imprimante.setDepartement(null);
        }
        imprimante.setStatus(RessourceStatus.CREE_PAR_ENSEIGNANT);
        imprimanteService.updateImprimante(imprimante);

        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }
        model.addAttribute("isChef", isChef);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute(USER_OBJECT, user);
        return "chefDepartement/BesionsChefDepartement";
    }

    @RequestMapping("chefDepartement/passerResponsable")
    public String passerResponsable(Model model, @AuthenticationPrincipal User user) {
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        List<Imprimante> imprimantes = new ArrayList<Imprimante>();
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        for (Enseignant enseignant : enseignants) {
            List<Imprimante> imprimantesEnseignant = imprimanteService.getAllImprimantCreeParEnsignant(enseignant.getId());
            imprimantes.addAll(imprimantesEnseignant);
            List<Ordinateur> ordinateursEnseignant = ordinateurService.getAllOrdinateurCreeParEnsignant(enseignant.getId());
            ordinateurs.addAll(ordinateursEnseignant);
        }

        for (Ordinateur ordinateur : ordinateurs) {
            ordinateur.setStatus(RessourceStatus.ENVOYE_RESPONSABLE);
            ordinateurService.updateOrdinateur(ordinateur);
        }

        for (Imprimante imprimante : imprimantes) {
            imprimante.setStatus(RessourceStatus.ENVOYE_RESPONSABLE);
            imprimanteService.updateImprimante(imprimante);
        }

        Long id = user.getId();
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        model.addAttribute(USER_OBJECT, user);
        return "enseignant/home";
    }


}
