package com.ressourcemanagement.service;

import com.ressourcemanagement.repository.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public boolean getDebartementbyIdChef(long id) {
        return departementRepository.existsDepartementByEnseignant_Id(id);
    }
}
