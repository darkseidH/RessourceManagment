package com.ressourcemanagement.service;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.Ordinateur;
import com.ressourcemanagement.repository.OrdinateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class OrdinateurService {
    @Autowired
    OrdinateurRepository ordinateurRepository;
    @Autowired
    EnseignantService enseignantService;

    public List<Ordinateur> getAllOrdinateurCreeParEnsignant(Long idEnsignant) {
        Enseignant enseignant = enseignantService.getEnsignatById(idEnsignant);
        RessourceStatus status = RessourceStatus.CREE_PAR_ENSEIGNANT;
        return ordinateurRepository.findAllByStatusAndEnseignant(status, enseignant);
    }

    public Ordinateur getOrdinateurById(long id) {
        return ordinateurRepository.findById(id).orElse(null);
    }

    public void deleteOrdinateur(long id) {
        ordinateurRepository.deleteById(id);
    }

    public void updateOrdinateur(Ordinateur ordinateur) {
        Ordinateur ordinateur1 = ordinateurRepository.findById(ordinateur.getId()).orElse(null);
        if (ordinateur1 != null) {
            ordinateur1.setId(ordinateur.getId());
            ordinateur1.setMarque(ordinateur.getMarque());
            ordinateur1.setEnseignant(ordinateur.getEnseignant());
            ordinateur1.setStatus(ordinateur.getStatus());
            ordinateur1.setDepartement(ordinateur.getDepartement());
            ordinateur1.setRam(ordinateur.getRam());
            ordinateur1.setDisk(ordinateur.getDisk());
            ordinateur1.setCpu(ordinateur.getCpu());
            ordinateur1.setEcran(ordinateur.getEcran());
            ordinateurRepository.save(ordinateur1);
        }
    }
}
