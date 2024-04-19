package com.ressourcemanagement.repository;

import org.springframework.stereotype.Repository;
import com.ressourcemanagement.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    boolean existsFournisseurByEmail(String username);
    Fournisseur getFournisseurByEmail(String username);
}
