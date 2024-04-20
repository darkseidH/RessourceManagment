package com.ressourcemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppelOffreDTO {
    private long id;
    private String dateDebut;
    private String dateFin;
    private String ressources;
}
