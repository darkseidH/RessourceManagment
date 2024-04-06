package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseigantRepository extends JpaRepository<Enseignant, Long> {
}
