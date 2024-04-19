package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.Departement;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.Notification;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.DepartementService;
import com.ressourcemanagement.service.EnseignantService;
import com.ressourcemanagement.service.NotificationService;
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
        boolean isChef = departementService.getDebartementbyIdChef(id);
        model.addAttribute("isChef", isChef);
        return "enseignant/home";
    }
}