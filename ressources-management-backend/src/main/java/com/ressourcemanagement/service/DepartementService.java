package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Departement;
import com.ressourcemanagement.repository.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public boolean getDebartementbyIdChef(long id) {
        return departementRepository.existsDepartementByEnseignant_Id(id);
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement findDepartementByIdChef(Long id) {
        return departementRepository.findDepartementByEnseignant_Id(id);
    }

    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }


}
