package com.ressourcemanagement.controller;

import com.ressourcemanagement.dto.PanneDTO;
import com.ressourcemanagement.model.Ordinateur;
import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.model.RessourceMaterielle;
import com.ressourcemanagement.model.User;
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
        model.addAttribute("user", user);
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

        RessourceMaterielle ressource;
        if (panne.getRessources() instanceof Ordinateur) {
            ressource = panne.getRessources();
        } else {
            ressource = panne.getRessources();
        }
        model.addAttribute("ressource", ressource);
        model.addAttribute("panne", panne);
        model.addAttribute("user", user);
        return "responsable/constats/voirConstat";
    }


    @GetMapping("/technicien/pannes")
    public String getAllConstats1(Model model, @AuthenticationPrincipal User user) {
        List<Panne> panneList = constatService.getAllConstats();
        model.addAttribute("panneList", panneList);
        model.addAttribute("user", user);
        return "technicien/panne";
    }

    // Technicien (Yassir)

    @GetMapping("/technicien/constats")
    public String getAllConstats2(Model model, @AuthenticationPrincipal User user) {
        List<Panne> panneList = constatService.getConstatsWithoutDateOrExplication();
        model.addAttribute("panneList", panneList);
        model.addAttribute("user", user);
        return "technicien/constat";
    }

    @GetMapping("/technicien/pannes/modifier/{id}")
    public String getConstat1(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal User user) {
        PanneDTO panne = constatService.getConstat(id);
//        System.out.println(panne);
        model.addAttribute("panne", panne);
        model.addAttribute("user", user);
        return "technicien/editPanne";
    }

//    @PostMapping("/technicien/pannes/modifier")
//    public String updateConstat1(@ModelAttribute("panne") Panne panne) {
//        constatService.updateConstat(panne);
//        return "redirect:/technicien/constats?success";
//    }

//    @PostMapping("/technicien/pannes/{id}/modifier")
//    public String updateConstat1(@PathVariable("id") long id,@ModelAttribute("panne") Panne panne, Model model,@AuthenticationPrincipal User user)
////                                 @RequestParam("frequence") String frequence,
////                                 @RequestParam("ordre") String ordre)
//                         {
//        System.out.println(panne.getExplication());
//        // Mettre à jour les valeurs de fréquence et d'ordre de la panne
////        if(frequence.equals("0"))
////        panne.setFrequence(PanneFrequence.RARE);
////        else if(frequence.equals("0"))
////            panne.setFrequence(PanneFrequence.PERMANANTE);
////        else  panne.setFrequence(PanneFrequence.FREQUENTE);
////
////        if(ordre.equals("0"))
////            panne.setOrdre(PaneOrder.LOGICIEL_UTIL);
////        else if (ordre.equals("1"))
////            panne.setOrdre(PaneOrder.SYSTEM);
////else
////            panne.setOrdre(PaneOrder.MATERIEL);
////
////        // Appeler le service pour mettre à jour le constat
////        constatService.updatePanne(panne);
//
//        // Redirection avec un message de succès
////        redirectAttributes.addFlashAttribute("success", "Constat mis à jour avec succès.");
//        return "redirect:/technicien/pannes";
//    }


//    @PostMapping("/technicien/pannes/{id}/modifier")
//    public String updateConstat(@PathVariable("id") long id, Panne panne, Model model,@AuthenticationPrincipal User user) {
//        // Faites ce que vous voulez avec les données récupérées
//        String explication = panne.getExplication();
//        System.out.println("Explication : " + explication);
//        List<Panne> panneList = constatService.getAllConstats();
//        model.addAttribute("panneList", panneList);
//        model.addAttribute("user", user);
//        // Redirigez vers une autre page après avoir traité les données du formulaire
//        return "technicien/panne";
//    }

    @PostMapping("/technicien/pannes/{id}/modifier")
    public String updateConstat(@PathVariable("id") long id, Panne panne, Model model, @AuthenticationPrincipal User user) {

        constatService.updatePanne(panne);

        List<Panne> panneList = constatService.getConstatsWithoutDateOrExplication();
        model.addAttribute("panneList", panneList);
        model.addAttribute("user", user);

        return "technicien/panne";
    }


}