package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
/*
**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:25 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public class Imprimante extends RessourceMaterielle {
    private int resolution;
    private double vitesseImpression;
}//end Imprement