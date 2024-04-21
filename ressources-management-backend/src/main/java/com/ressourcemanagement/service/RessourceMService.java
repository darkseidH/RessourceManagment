package com.ressourcemanagement.service;

import com.ressourcemanagement.model.RessourceMaterielle;

import java.util.List;

public interface RessourceMService {

    List<RessourceMaterielle> getAllRessourceMaterielle();
    void saveRessourceMaterielle(RessourceMaterielle ressourceMaterielle);

}
