package com.ressourcemanagement.model;


import jakarta.persistence.OneToMany;

import java.util.ArrayList;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:21 AM
 */
public class Departement {
	private long idDepartement;
	private long idChef;
	private String nom;
	private ArrayList<Enseignant> enseignants;
	@OneToMany
	private ArrayList<RessourceMaterielle> ressourceMaterielles;
}//end Departement