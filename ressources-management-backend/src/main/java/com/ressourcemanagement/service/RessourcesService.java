package com.ressourcemanagement.service;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.RessourceMaterielle;
import com.ressourcemanagement.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourcesService {
    @Autowired
    private RessourceRepository ressourceRepository;

    public List<RessourceMaterielle> findAllRessoucesByStatus(RessourceStatus status) {
        return ressourceRepository.findAllByStatus(status);
    }

}
