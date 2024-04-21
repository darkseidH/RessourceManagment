package com.ressourcemanagement.controller;


import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.model.Soumission;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @GetMapping("/fournisseur/soumission/{id}")
    public String getappelOffreDetails(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal User user) {
        AppelOffre appelOffreDetails = fournisseurService.getappelOffreDetails(id);
        // Vérifiez si l'appel d'offres a été trouvé
        if (appelOffreDetails == null) {
            // Gérer le cas où l'appel d'offres n'est pas trouvé, peut-être renvoyer une erreur 404
            return "error/404"; // C'est un exemple, vous devrez créer le modèle "error/404"
        }
        List<Soumission> soumissions = new ArrayList<>();
        model.addAttribute("soumission", soumissions);
        model.addAttribute("appeloffre", appelOffreDetails);
        model.addAttribute("user", user);
        return "fournisseur/soumission";
    }
    @PostMapping("/fournisseur/soumission/{id}")
    public String addSoumission(@PathVariable("id") Long id,
                                @ModelAttribute("soumission") List<Soumission> soumissions,
                                Model model,
                                @AuthenticationPrincipal User user) {

        // Ajouter le fournisseur à chaque soumission
        for (Soumission soumission : soumissions) {

            // Enregistrer chaque soumission dans la base de données ou dans votre service
            fournisseurService.saveSoumission(soumission);
        }

        // Rediriger vers la page de détails de l'appel d'offres après l'ajout des soumissions
        return "redirect:/fournisseur/soumission/{id}?success";
    }



}
