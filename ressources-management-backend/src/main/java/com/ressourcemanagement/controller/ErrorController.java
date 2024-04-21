package com.ressourcemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String getErrorPage(Model model, @RequestParam("errorMessage") String errorMessage) {
        model.addAttribute("errorMessage", errorMessage);
        return "404";
    }
}
