package com.ressourcemanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:21 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	@OneToMany(mappedBy = "departement")
	private List<Enseignant> enseignants;
	@OneToMany(mappedBy = "departement")
	private List<RessourceMaterielle> ressources;
}//end Departement