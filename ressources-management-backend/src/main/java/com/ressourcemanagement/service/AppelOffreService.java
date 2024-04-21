package com.ressourcemanagement.service;

import com.ressourcemanagement.dto.AppelOffreDTO;
import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.repository.AppelOffreRepository;
import com.ressourcemanagement.repository.RessourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppelOffreService {
    @Autowired
    private AppelOffreRepository appelOffreRepository;
    @Autowired
    private RessourceRepository ressourceRepository;

    public AppelOffreService() {
    }

    public List<AppelOffre> getAllAppelOffres() {
        return appelOffreRepository.findAll();
    }

    public AppelOffre getAppelOffreById(long id) {
        return appelOffreRepository.findById(id).orElse(null);
    }

    public void saveAppelOffre(AppelOffre appelOffre) {
        appelOffreRepository.save(appelOffre);
    }

    public void deleteAppelOffre(long id) {
        appelOffreRepository.deleteById(id);
    }

    public void addAppelOffre(AppelOffreDTO appelOffreDTO) {
        AppelOffre appelOffre = new AppelOffre();
        appelOffre.setDateDebut(appelOffreDTO.getDate_debut());
        appelOffre.setDateFin(appelOffreDTO.getDate_fin());
        saveAppelOffre(appelOffre);
        ressourceRepository.findAllByStatus(RessourceStatus.ENVOYE_RESPONSABLE).forEach(r -> {
            r.setAppelOffre(appelOffre);
            r.setStatus(RessourceStatus.APPEL_OFFRE);
            ressourceRepository.save(r);
        });
    }
}
