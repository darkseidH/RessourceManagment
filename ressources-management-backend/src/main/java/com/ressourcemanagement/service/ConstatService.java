package com.ressourcemanagement.service;

import com.ressourcemanagement.dto.PanneDTO;
import com.ressourcemanagement.model.Panne;
import com.ressourcemanagement.repository.PanneRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstatService {
    @Autowired
    private PanneRepository panneRepository;

    public List<Panne> getAllConstats() {
        List<Panne> panneList = panneRepository.findAll();
        val filtredPanneList = panneList.stream().filter(panne -> !panne.isDemanderReparer() && !panne.isDemanderChanger()).toList();
        return filtredPanneList;
    }

    public PanneDTO getConstat(Long id) {
        Panne panne = panneRepository.findById(id).orElse(null);
        PanneDTO panneDTO = new PanneDTO();
        if (panne != null) {
            panneDTO.setId(panne.getId());
            panneDTO.setDateApparition(panne.getDateApparition());
            panneDTO.setDemanderChanger(panne.isDemanderChanger());
            panneDTO.setDemanderReparer(panne.isDemanderReparer());
            panneDTO.setExplication(panne.getExplication());
            panneDTO.setFrequence(panne.getFrequence());
            panneDTO.setOrdre(panne.getOrdre());
            panneDTO.setPanneFrequence(panne.getFrequence());
            panneDTO.setRessources(panne.getRessources());
        }
        return panneDTO;
    }

    public void updateConstat(PanneDTO panne) {
        Panne existingPanne = panneRepository.findById(panne.getId()).orElse(null);
        if (existingPanne != null) {
            existingPanne.setDateApparition(panne.getDateApparition());
            existingPanne.setDemanderChanger(panne.isDemanderChanger());
            existingPanne.setDemanderReparer(panne.isDemanderReparer());
            existingPanne.setFrequence(panne.getFrequence());
            existingPanne.setExplication(panne.getExplication());
            existingPanne.setOrdre(panne.getOrdre());
            panneRepository.save(existingPanne);
        }
    }
    public void updatePanne(Panne panne) {
        Panne existingPanne = panneRepository.findById(panne.getId()).orElse(null);
        if (existingPanne != null) {
            existingPanne.setDateApparition(panne.getDateApparition());
            existingPanne.setFrequence(panne.getFrequence());
            existingPanne.setExplication(panne.getExplication());
            existingPanne.setOrdre(panne.getOrdre());
            panneRepository.save(existingPanne);
        }
    }

    public List<Panne> getConstatsWithoutDateOrExplication() {
        return panneRepository.findAllByDateApparitionIsNullOrExplicationIsNull();
    }
}