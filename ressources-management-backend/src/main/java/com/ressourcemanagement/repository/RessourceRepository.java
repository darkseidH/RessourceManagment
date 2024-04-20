package com.ressourcemanagement.repository;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.RessourceMaterielle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepository extends JpaRepository<RessourceMaterielle, Long> {
    List<RessourceMaterielle> findAllByStatus(RessourceStatus status);
}
