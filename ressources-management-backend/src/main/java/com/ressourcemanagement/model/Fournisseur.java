package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:24 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public class Fournisseur extends User {
    private String adresse;
    private String nomBoss;
    private String prenomBoss;
    private String lieu;
    private boolean isblackListed;
    private String nomSociete;
    private String siteInternet;
    @OneToMany(mappedBy = "fournisseur")
    private List<Soumission> soumissions;

}//end Fournisseur