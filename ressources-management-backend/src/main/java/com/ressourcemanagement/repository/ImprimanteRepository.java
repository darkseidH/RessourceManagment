package com.ressourcemanagement.repository;

import com.ressourcemanagement.enumeration.RessourceStatus;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.Imprimante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImprimanteRepository extends JpaRepository<Imprimante, Long> {

    List<Imprimante> findAllByStatusAndEnseignant(RessourceStatus status, Enseignant enseignant);
}
