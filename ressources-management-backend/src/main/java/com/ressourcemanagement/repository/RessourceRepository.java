package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.RessourceMaterielle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<RessourceMaterielle, Long> {
}
