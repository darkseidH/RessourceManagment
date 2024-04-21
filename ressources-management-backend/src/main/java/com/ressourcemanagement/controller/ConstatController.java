package com.ressourcemanagement.controller;

import com.ressourcemanagement.dto.PanneDTO;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.ConstatService;
import com.ressourcemanagement.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_RESPONSABLE')")
public class ConstatController {
    @Autowired
    private ConstatService constatService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/responsable/constats")
    public String getAllConstats(Model model, @AuthenticationPrincipal User user) {
        List<Panne> panneList = constatService.getAllConstats();
        model.addAttribute("panneList", panneList);
        model.

                addAttribute("user", user);
        return "responsable/constats/constats";
    }

    @GetMapping("/responsable/constats/modifier/{id}")
    public String getConstat(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal User user) {
        PanneDTO panne = constatService.getConstat(id);
        RessourceMaterielle ressourceMaterielle = panne.getRessources();
        boolean garantie;
        garantie = !ressourceMaterielle.getDate_fin_garantie().before(new Date());
        model.addAttribute("garantie", garantie);
        model.addAttribute("panne", panne);
        model.addAttribute("user", user);
        return "responsable/constats/editConstat";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping("/responsable/constats/modifier")
    public String updateConstat(@ModelAttribute("panne") PanneDTO panne) {
        constatService.updateConstat(panne);
//        Notification notification = Notification.builder()
//                .content("Nouvelle panne qui concerne un materiel est arrivé " + panne.getRessources().getId())
//                .user()
//        notificationService.saveNotification();
        return "redirect:/responsable/constats?success";
    }

    @GetMapping("/responsable/constats/{id}")
    public String getConstatToVisualise(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal User user) {
        PanneDTO panne = constatService.getConstat(id);
        if (panne.getRessources() instanceof Ordinateur) {
            RessourceMaterielle ressources = panne.getRessources();
            model.addAttribute("ordinateur", ressources);
        } else {
            RessourceMaterielle ressources = panne.getRessources();
            model.addAttribute("imprimante", ressources);
        }
        Ordinateur ordinateur = (Ordinateur) panne.getRessources();
        model.addAttribute("panne", panne);
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("user", user);
        return "responsable/constats/voirConstat";
    }


}