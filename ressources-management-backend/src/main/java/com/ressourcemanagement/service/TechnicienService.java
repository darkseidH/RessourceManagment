package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.model.Technicien;
import com.ressourcemanagement.repository.PanneRepository;
import com.ressourcemanagement.repository.TechnicienRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnicienService {
    @Autowired
    private TechnicienRepository technicienRepository;
    private PanneRepository panneRepository;

    public List<Technicien> getAllTechnicien() {
        return technicienRepository.findAll();
    }

    public List<Panne> getAllPanne() {
        return panneRepository.findAll();
    }


}
