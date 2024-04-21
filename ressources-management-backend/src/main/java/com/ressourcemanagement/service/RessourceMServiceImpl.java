package com.ressourcemanagement.service;

import com.ressourcemanagement.model.RessourceMaterielle;
import com.ressourcemanagement.repository.RessouceMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceMServiceImpl implements RessourceMService {

    @Autowired
    private RessouceMRepository ressouceMRepository;

    @Override
    public List<RessourceMaterielle> getAllRessourceMaterielle() {
        return ressouceMRepository.findAll();
    }

    @Override
    public void saveRessourceMaterielle(RessourceMaterielle ressourceMaterielle) {
        ressouceMRepository.save(ressourceMaterielle);
    }

}
