package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Enseignant findByEmail(String email);

    List<Enseignant> findAllByDepartement_Id(Long id);
}
