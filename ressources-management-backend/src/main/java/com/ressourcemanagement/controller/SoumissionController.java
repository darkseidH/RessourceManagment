package com.ressourcemanagement.controller;

import com.ressourcemanagement.service.SoumissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@PreAuthorize("hasRole('ROLE_RESPONSABLE')")
public class SoumissionController {
    @Autowired
    private SoumissionService soumissionService;


}
