package com.ressourcemanagement.controller;

import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PanneController {

    @Autowired
    EnseignantService enseignantService;
    @Autowired
    private ImprimanteService imprimanteService;
    @Autowired
    private OrdinateurService ordinateurService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private PanneService panneService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private TechnicienService technicienService;


//    @GetMapping("/panne/signalerPanne/{id}/imprimante")
//    public String signalerPanneImprimante(@PathVariable("id") long id , Model model, @AuthenticationPrincipal User user) {
//        Imprimante imprimante = imprimanteService.getImprimanteById(id);
//        List<Technicien> techniciens = technicienService.getAllTechnicien();
//        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
//        for(Technicien technicien : techniciens){
//            Panne panne = new Panne().builder().ressources(imprimante).technicien(technicien).build();
//            panneService.savePanne(panne);
//            String message = "Une panne a été signalée sur l'imprimante "+imprimante.getMarque() + " par l'enseignant "+enseignant.getNom()+" "+enseignant.getPrenom() + " de département "+enseignant.getDepartement().getNom();
//            Notification notification = new Notification().builder().user(technicien).content(message).build();
//            notificationService.saveNotification(notification);
//        }
  //      List<Imprimante> imprimantes = imprimanteService.getAllImprimantAffecterEnsignant(user.getId());
  //      List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
 //       model.addAttribute("imprimantes", imprimantes);
 //       model.addAttribute("ordinateurs", ordinateurs);

    @GetMapping("/panne/signalerPanne/{id}/imprimante")
    public String signalerPanneImprimante(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Imprimante imprimante = imprimanteService.getImprimanteById(id);
        List<Technicien> techniciens = technicienService.getAllTechnicien();
        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
        for (Technicien technicien : techniciens) {
            new Panne();
            Panne panne = Panne.builder().ressources(imprimante).technicien(technicien).build();
            panneService.savePanne(panne);
            String message = "Une panne a été signalée sur l'imprimante " + imprimante.getMarque() + " par l'enseignant " + enseignant.getNom() + " " + enseignant.getPrenom() + " de département " + enseignant.getDepartement().getNom();
            new Notification();
            Notification notification = Notification.builder().user(technicien).content(message).build();
            notificationService.saveNotification(notification);
        }
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantAffecterEnsignant(user.getId());
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("user", user);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        return "enseignant/RessourcesEnseignant";
    }

//    @GetMapping("/panne/signalerPanne/{id}/ordinateur")
//    public String signalerPanneOrdinateur(@PathVariable("id") long id , Model model, @AuthenticationPrincipal User user) {
//        Ordinateur ordinateur = ordinateurService.getOrdinateurById(id);
//        List<Technicien> techniciens = technicienService.getAllTechnicien();
//        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
//        for(Technicien technicien : techniciens){
//            Panne panne = new Panne().builder().ressources(ordinateur).technicien(technicien).build();
//            panneService.savePanne(panne);
//            String message = "Une panne a été signalée sur l'ordinateur "+ordinateur.getMarque() + " par l'enseignant "+enseignant.getNom()+" "+enseignant.getPrenom() + " de département "+enseignant.getDepartement().getNom();
//            Notification notification = new Notification().builder().user(technicien).content(message).build();
//            notificationService.saveNotification(notification);
//        }
//        List<Imprimante> imprimantes = imprimanteService.getAllImprimantAffecterEnsignant(user.getId());
//        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
//        model.addAttribute("imprimantes", imprimantes);
//        model.addAttribute("ordinateurs", ordinateurs);
    public String signalerPanneOrdinateur(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        Ordinateur ordinateur = ordinateurService.getOrdinateurById(id);
        List<Technicien> techniciens = technicienService.getAllTechnicien();
        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
        for (Technicien technicien : techniciens) {
            new Panne();
            Panne panne = Panne.builder().ressources(ordinateur).technicien(technicien).build();
            panneService.savePanne(panne);
            String message = "Une panne a été signalée sur l'ordinateur " + ordinateur.getMarque() + " par l'enseignant " + enseignant.getNom() + " " + enseignant.getPrenom() + " de département " + enseignant.getDepartement().getNom();
            new Notification();
            Notification notification = Notification.builder().user(technicien).content(message).build();
            notificationService.saveNotification(notification);
        }
        List<Imprimante> imprimantes = imprimanteService.getAllImprimantAffecterEnsignant(user.getId());
        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("user", user);
        boolean isChef = departementService.getDebartementbyIdChef(user.getId());
        model.addAttribute("isChef", isChef);
        return "enseignant/RessourcesEnseignant";
    }

//    @GetMapping("/panne/redigerConstat/{id}/ordinateur")
//    public String redigerConstatOrdinateur(@PathVariable("id") long id , Model model, @AuthenticationPrincipal User user) {
//        Ordinateur ordinateur = ordinateurService.getOrdinateurById(id);
//        List<Technicien> techniciens = technicienService.getAllTechnicien();
//        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());
//        for (Technicien technicien : techniciens) {
//            Panne panne = new Panne().builder().ressources(ordinateur).technicien(technicien).build();
//            panneService.savePanne(panne);
//
//        }
////        List<Imprimante> imprimantes = imprimanteService.
////        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
////        model.addAttribute("imprimantes", imprimantes);
////        model.addAttribute("ordinateurs", ordinateurs);
//        model.addAttribute("user", user);
//        return "technicien/ressourcePanne";
//    }

    @GetMapping("/panne/redigerConstat/{id}/imprimante")
    public String redigerConstatImprimante(@PathVariable("id") long id , Model model, @AuthenticationPrincipal User user) {

        Imprimante imprimante = imprimanteService.getImprimanteById(id);
        Enseignant enseignant = enseignantService.getEnsignatById(user.getId());

      //      Panne panne = new Panne().builder().ressources(ordinateur).technicien(technicien).build();
      //      panneService.savePanne(panne);


   //     List<Imprimante> imprimantes = imprimanteService.getImprimanteById(user.getId());
//        List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurAffecterEnsignant(user.getId());
//        model.addAttribute("imprimantes", imprimantes);
//        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("user", user);

        return "technicien/ressourcePanne";
    }







}
