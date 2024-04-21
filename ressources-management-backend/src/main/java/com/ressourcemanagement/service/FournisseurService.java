package com.ressourcemanagement.service;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.repository.AppelOffreRepository;
import com.ressourcemanagement.repository.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ressourcemanagement.repository.FournisseurRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private AppelOffreRepository appleOffreRepository;
//    public boolean existFournisseur(String username) {
//        return fournisseurRepository.existsFournisseurByEmail(username);
//    }
public Fournisseur getFournissuerByEmail(String username) {
   return fournisseurRepository.getFournisseurByEmail(username);
    }

    public List<AppelOffre> getAllAppleOffre() {
        return appleOffreRepository.findAll();
    }

}
