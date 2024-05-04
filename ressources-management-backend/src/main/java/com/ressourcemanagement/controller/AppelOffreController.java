package com.ressourcemanagement.controller;

import com.ressourcemanagement.dto.AppelOffreDTO;
import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.service.AppelOffreService;
import com.ressourcemanagement.service.RessourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_RESPONSABLE')")
public class AppelOffreController {
    @Autowired
    private AppelOffreService appelOffreService;
    @Autowired
    private RessourcesService ressourceMaterielleService;

    @GetMapping("/responsable/appel-offres")
    public String getAllAppelOffres(Model model, @AuthenticationPrincipal User user) {
        List<AppelOffre> appelOffres = appelOffreService.getAllAppelOffres();
        model.addAttribute("user", user);
        model.addAttribute("appelOffres", appelOffres);
        return "responsable/appel-offres/appels-offres";
    }

    @GetMapping("/responsable/appel-offres/add")
    public String addAppelOffre(Model model, @AuthenticationPrincipal User user) {
        AppelOffreDTO appelOffre = new AppelOffreDTO();

        List<RessourceMaterielle> ressourceMaterielles =
                ressourceMaterielleService.findAllRessoucesByStatus(RessourceStatus.ENVOYE_RESPONSABLE);
        List<Ordinateur> ordinateurs = ressourceMaterielles.stream().filter(r -> r instanceof Ordinateur).map(r -> (Ordinateur) r).toList();
        List<Imprimante> imprimantes =
                ressourceMaterielles.stream().filter(r -> r instanceof Imprimante).map(r -> (Imprimante) r).toList();

        model.addAttribute("appeloffre", appelOffre);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("user", user);
        return "/responsable/appel-offres/ajouter-appel-offre";
    }

    @PostMapping("/responsable/appel-offres/add")
    public String addAppelOffre(AppelOffreDTO appelOffreDTO, @AuthenticationPrincipal User user) {
        appelOffreService.addAppelOffre(appelOffreDTO);
        return "redirect:/responsable/appel-offres?added-successfully";
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


    @GetMapping("/responsable/appel-offres/{id}/modifier")
    public String editAppelOffre(Model model, @PathVariable("id") long id, @AuthenticationPrincipal User user) {
        AppelOffre appelOffre = appelOffreService.getAppelOffreById(id);
        AppelOffreDTO appelOffreDTO = AppelOffreDTO.builder()
                .id(appelOffre.getId())
                .date_debut(appelOffre.getDateDebut())
                .date_fin(appelOffre.getDateFin())
                .build();
        List<RessourceMaterielle> ressourceMaterielles =
                ressourceMaterielleService.findAllRessoucesByStatus(RessourceStatus.ENVOYE_RESPONSABLE);
        List<Ordinateur> ordinateurs =
                ressourceMaterielles.stream().filter(r -> r instanceof Ordinateur && r.getAppelOffre() == null)
                        .map(r -> (Ordinateur) r).toList();
        List<Imprimante> imprimantes =
                ressourceMaterielles.stream().filter(r -> r instanceof Imprimante && r.getAppelOffre() == null)
                        .map(r -> (Imprimante) r).toList();
        model.addAttribute("appeloffre", appelOffreDTO);
        model.addAttribute("ordinateurs", ordinateurs);
        model.addAttribute("imprimantes", imprimantes);
        model.addAttribute("user", user);
        return "/responsable/appel-offres/edit-appel-offre";
    }

    @PostMapping("/responsable/appel-offres/{id}/modifier")
    public String editAppelOffre(AppelOffreDTO appelOffreDTO, @PathVariable("id") long id, @AuthenticationPrincipal User user) {
        appelOffreService.editAppelOffre(appelOffreDTO, id);
        return "redirect:/responsable/appel-offres?edited-successfully";
    }


    @GetMapping("/responsable/appel-offres/{id}/delete")
    public String deleteAppelOffre(@PathVariable("id") long id, @AuthenticationPrincipal User user) {
        appelOffreService.deleteAppelOffre(id);
        return "redirect:/responsable/appel-offres?deleted-successfully";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/responsable/appel-offres/{id}/soumissions")
    public String getAppelOffreSoumission(@PathVariable("id") long id, @AuthenticationPrincipal User user,
                                          Model model) {
        AppelOffre appelOffre = appelOffreService.getAppelOffreById(id);
        List<RessourceMaterielle> appelOffreRessources = appelOffre.getRessources();
        List<Soumission> soumissions = appelOffreRessources.stream()
                .flatMap(ressource -> ressource.getSoumissions().stream())
                .toList();
        HashMap<RessourceMaterielle, List<Soumission>> ressourceSoumission = new HashMap<>();
        appelOffreRessources.forEach(ressource -> {
            List<Soumission> soumissionList =
                    soumissions.stream().filter(soumission -> soumission.getRessources().getId() == ressource.getId()).toList();
            ressourceSoumission.put(ressource, soumissionList);
        });
        model.addAttribute("appelOffre", appelOffre);
        model.addAttribute("user", user);
        model.addAttribute("ressourceSoumission", ressourceSoumission);
        return "responsable/appel-offres/soumissions";
    }
}
