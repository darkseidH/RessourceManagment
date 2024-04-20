package com.ressourcemanagement.service;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.repository.AppelOffreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppelOffreService {
    @Autowired
    private AppelOffreRepository appelOffreRepository;

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
}
