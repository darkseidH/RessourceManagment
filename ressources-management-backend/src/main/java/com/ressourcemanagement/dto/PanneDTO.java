package com.ressourcemanagement.dto;

import com.ressourcemanagement.enumeration.PaneOrder;
import com.ressourcemanagement.enumeration.PanneFrequence;
import com.ressourcemanagement.model.RessourceMaterielle;
import lombok.*;

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

    // getters and setters
}
