package com.ressourcemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoumissionDTO {
    private long id;
    private Date date_livraison;
    private Date date_garantie;
    private String marque;
    private double prix;

}
