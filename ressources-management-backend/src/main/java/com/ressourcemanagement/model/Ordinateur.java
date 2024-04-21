package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:28 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public class Ordinateur extends RessourceMaterielle {
    private String cpu;
    private String disk;
    private String ecran;
    private String ram;

    @Override
    public String getType() {
        return "Ordinateur";
    }
}//end Ordinateur