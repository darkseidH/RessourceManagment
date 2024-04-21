package com.ressourcemanagement.service;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.model.Soumission;
import com.ressourcemanagement.repository.AppelOffreRepository;
import com.ressourcemanagement.repository.FournisseurRepository;
import com.ressourcemanagement.repository.SoumissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private AppelOffreService appeloffreService;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private AppelOffreRepository appleOffreRepository;
    @Autowired
    private SoumissionRepository soumissionRepository;

    //    public boolean existFournisseur(String username) {
//        return fournisseurRepository.existsFournisseurByEmail(username);
//    }
    public Fournisseur getFournissuerByEmail(String username) {
        return fournisseurRepository.getFournisseurByEmail(username);
    }

    public List<AppelOffre> getAllAppleOffre() {
        return appleOffreRepository.findAll();
    }
    public AppelOffre getappelOffreDetails(long id){
        return appeloffreService.getAppelOffreById(id);
    }
    public Soumission saveSoumission(Soumission soumission){  return soumissionRepository.save(soumission);
    }
}
