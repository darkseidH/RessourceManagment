package com.ressourcemanagement.dto;

import com.ressourcemanagement.enumeration.PaneOrder;
import com.ressourcemanagement.enumeration.PanneFrequence;
import com.ressourcemanagement.model.RessourceMaterielle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PanneDTO {
    private Long id;
    private Date dateApparition;
    private boolean demanderChanger;
    private boolean demanderReparer;
    private String explication;
    private PanneFrequence frequence;
    private PaneOrder ordre;
    private PanneFrequence panneFrequence;
    private RessourceMaterielle ressources;

    //imprimante
    private int resolution;
    private double vitesseImpression;

    // getters and setters
}
