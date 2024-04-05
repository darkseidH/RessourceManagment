package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:24 AM
 */
@Entity
public class Fournisseur extends User {
    private long idFournisseur;
    private String adresse;
    private String nomBoss;
    private String prenomBoss;
    private String lieu;
    private boolean listeNoire;
    private String nomSociete;
    private String siteInternet;
    private ArrayList<Soumition> soumissions;

}//end Fournisseur