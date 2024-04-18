package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneRepository extends JpaRepository<Panne, Long> {
}
