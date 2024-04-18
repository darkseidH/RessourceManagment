package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Enseignant findByEmail(String email);
}
