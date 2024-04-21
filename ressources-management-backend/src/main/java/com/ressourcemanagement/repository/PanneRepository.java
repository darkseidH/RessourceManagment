package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanneRepository extends JpaRepository<Panne, Long> {
    List<Panne> findAllByDateApparitionIsNullOrExplicationIsNull();


}
