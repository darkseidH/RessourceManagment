package com.ressourcemanagement.repository;


import com.ressourcemanagement.model.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoumissionRepository extends JpaRepository<Soumission, Long> {
}
