package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.repository.EnseignantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant getEnseignatByEmail(String email) {
        return enseignantRepository.findByEmail(email);
    }
}
