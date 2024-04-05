package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:16 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AppelOffre {
    @Id
    @GeneratedValue
    private Long idAppelOffre;
    private Date dateDebut;
    private Date dateFin;
    @OneToMany
    private ArrayList<RessourceMaterielle> ressourceMaterielles;
}