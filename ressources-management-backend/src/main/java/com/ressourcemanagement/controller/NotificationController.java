package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private ImprimanteService imprimanteService;
    @Autowired
    private OrdinateurService ordinateurService;

    @GetMapping("/Notification/AjouterNotificationDEBesions")
    public String ajouterNotificationDEBesions(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        Departement departement = departementService.findDepartementByIdChef(user.getId());
        List<Enseignant> enseignants = enseignantService.findAllByDepartement_Id(departement.getId());
        for (Enseignant enseignant : enseignants) {
            Notification notification = Notification.builder().user(enseignant).content("il faut envoyer votre Besoins").isReaded(false).build();
            notificationService.saveNotification(notification);
        }

        Long id = user.getId();
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantCreeParEnsignant(id);
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurCreeParEnsignant(id);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        boolean isChef = departementService.getDebartementbyIdChef(id);
        model.addAttribute("isChef", isChef);
        return "enseignant/home";
    }
}