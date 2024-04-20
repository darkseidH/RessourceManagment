package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    boolean existsFournisseurByEmail(String username);

    Fournisseur getFournisseurByEmail(String username);
}
