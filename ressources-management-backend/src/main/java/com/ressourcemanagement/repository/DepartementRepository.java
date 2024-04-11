package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
}
