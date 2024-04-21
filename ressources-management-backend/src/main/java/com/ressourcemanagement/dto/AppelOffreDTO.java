package com.ressourcemanagement.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppelOffreDTO {
    private long id;
    private Date date_debut;
    private Date date_fin;
    private List<Long> imprimanteIds;
    private List<Long> ordinateurIds;
}
