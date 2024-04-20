package com.ressourcemanagement.repository;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.Ordinateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {
    List<Ordinateur> findAllByStatusAndEnseignant(RessourceStatus status, Enseignant enseignant);
}
