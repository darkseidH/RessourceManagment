package com.ressourcemanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:16 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class AppelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateDebut;
    private Date dateFin;
    @OneToMany(mappedBy = "appelOffre")
    private List<RessourceMaterielle> ressources;
}