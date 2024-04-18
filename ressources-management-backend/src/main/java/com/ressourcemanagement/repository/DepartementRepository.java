package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    boolean existsDepartementByEnseignant_Id(Long enseignantId);
}
