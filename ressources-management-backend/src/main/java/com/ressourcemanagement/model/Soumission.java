package com.ressourcemanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:37 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Soumission {
	@ManyToOne
	@JoinColumn(name = "fournisseur_id", nullable = false)
	public Fournisseur fournisseur;
	private Date dateLivraison;
	@ManyToOne
	@JoinColumn(name = "ressource_id", nullable = false)
	public RessourceMaterielle ressources;
	private String marque;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int dureeGarantie;
	private double prix;
}//end Soumition