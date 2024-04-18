package com.ressourcemanagement.controller;

import com.ressourcemanagement.dto.PanneDTO;
import com.ressourcemanagement.model.Ordinateur;
import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.ConstatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ConstatController {
    @Autowired
    private ConstatService constatService;

    @GetMapping("/responsable/constats")
    public String getAllConstats(Model model, @AuthenticationPrincipal User user) {
        List<Panne> panneList = constatService.getAllConstats();
        model.addAttribute("panneList", panneList);
        model.addAttribute("user", user);
        return "responsable/constat";
    }

    @GetMapping("/responsable/constats/modifier/{id}")
    public String getConstat(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal User user) {
        PanneDTO panne = constatService.getConstat(id);
//        System.out.println(panne);
        model.addAttribute("panne", panne);
        model.addAttribute("user", user);
        return "responsable/editConstat";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping("/responsable/constats/modifier")
    public String updateConstat(@ModelAttribute("panne") Panne panne) {
        constatService.updateConstat(panne);
        return "redirect:/responsable/constats?success";
    }

    @GetMapping("/responsable/constats/{id}")
    public String getConstatToVisualise(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal User user) {
        PanneDTO panne = constatService.getConstat(id);
        Ordinateur ordinateur = (Ordinateur) panne.getRessources();
        model.addAttribute("panne", panne);
        model.addAttribute("ordinateur", ordinateur);
        model.addAttribute("user", user);
        return "responsable/voirConstat";
    }


}