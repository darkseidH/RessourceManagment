package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

}
