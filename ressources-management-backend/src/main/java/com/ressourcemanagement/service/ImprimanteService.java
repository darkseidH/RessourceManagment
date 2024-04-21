package com.ressourcemanagement.service;


import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.Imprimante;
import com.ressourcemanagement.repository.ImprimanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImprimanteService {
    @Autowired
    EnseignantService enseignantService;
    @Autowired
    private ImprimanteRepository imprimanteRepository;

    public List<Imprimante> getAllImprimantCreeParEnsignant(Long idEnsignant) {
        Enseignant enseignant = enseignantService.getEnsignatById(idEnsignant);
        RessourceStatus status = RessourceStatus.CREE_PAR_ENSEIGNANT;
        return imprimanteRepository.findAllByStatusAndEnseignant(status, enseignant);
    }

    public Imprimante getImprimanteById(long id) {
        return imprimanteRepository.findById(id).orElse(null);
    }

    public void deleteImprimante(long id) {
        imprimanteRepository.deleteById(id);
    }

    public void saveImprimante(Imprimante imprimante) {
        imprimanteRepository.save(imprimante);
    }

    public void updateImprimante(Imprimante imprimante) {
        Imprimante imprimanteToUpdate = imprimanteRepository.findById(imprimante.getId()).orElse(null);
        if (imprimanteToUpdate != null) {
            imprimanteToUpdate.setId(imprimante.getId());
            imprimanteToUpdate.setMarque(imprimante.getMarque());
            imprimanteToUpdate.setDepartement(imprimante.getDepartement());
            imprimanteToUpdate.setStatus(imprimante.getStatus());
            imprimanteToUpdate.setVitesseImpression(imprimante.getVitesseImpression());
            imprimanteToUpdate.setResolution(imprimante.getResolution());
        }
        imprimanteRepository.save(imprimanteToUpdate);
    }

    public void deleteImprimant(Long id) {
        imprimanteRepository.deleteById(id);
    }

    public List<Imprimante> getAllImprimantAffecterEnsignant(Long id) {
        return imprimanteRepository.findAllByStatusAndEnseignant(RessourceStatus.AFFECTE_APRES_LIVRAISON, enseignantService.getEnsignatById(id));
    }
}
