package com.ressourcemanagement.model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.ressourcemanagement.enumeration.RessourceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class RessourceMaterielle {
    private int idProfesseur;
    private int idDepartement;
    private int barCOde;
    private RessourceStatus status;
    @Id
    private Long id;
    private List<Soumition> soumitions;

}
