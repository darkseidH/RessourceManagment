package com.ressourcemanagement.service;

import com.ressourcemanagement.dto.SoumissionDTO;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.model.RessourceMaterielle;
import com.ressourcemanagement.model.Soumission;
import com.ressourcemanagement.repository.FournisseurRepository;
import com.ressourcemanagement.repository.RessourceRepository;
import com.ressourcemanagement.repository.SoumissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoumissionService {
    @Autowired
    private SoumissionRepository soumissionRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private RessourceRepository ressourceRepository;

    public void saveSoumission(SoumissionDTO soumissionDto, long id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
        RessourceMaterielle ressourceMaterielle = ressourceRepository.findById(soumissionDto.getId()).orElse(null);
        Soumission soumission = Soumission.builder()
                .dateLivraison(soumissionDto.getDate_livraison())
                .dateGarantie(soumissionDto.getDate_garantie())
                .marque(soumissionDto.getMarque())
                .prix(soumissionDto.getPrix())
                .fournisseur(fournisseur)
                .ressources(ressourceMaterielle)
                .build();
        soumissionRepository.save(soumission);
    }
}
