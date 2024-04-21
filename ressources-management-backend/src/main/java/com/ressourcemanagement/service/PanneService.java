package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.repository.PanneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PanneService {

    @Autowired
    PanneRepository panneRepository;


    public void savePanne(Panne panne) {
        panneRepository.save(panne);
    }
}
