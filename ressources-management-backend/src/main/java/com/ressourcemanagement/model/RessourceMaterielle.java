package com.ressourcemanagement.model;

import com.ressourcemanagement.enumeration.RessourceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public abstract class RessourceMaterielle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int barCode;
    private String marque;
    private RessourceStatus status;
    private Date date_fin_garantie;
    @ManyToOne
    @JoinColumn(name = "enseigant_id", nullable = true)
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "departement_id", nullable = true)
    private Departement departement;
    @OneToMany(mappedBy = "ressources")
    private List<Soumission> soumissions;
    @OneToMany(mappedBy = "ressources")
    private List<Panne> pannes;
    @ManyToOne
    @JoinColumn(name = "appel_offre_id", nullable = true)
    private AppelOffre appelOffre;

    public abstract String getType();

}
