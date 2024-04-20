package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Technicien;
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

    public List<Technicien> getAllTechnicien() {
        return technicienRepository.findAll();
    }
}
