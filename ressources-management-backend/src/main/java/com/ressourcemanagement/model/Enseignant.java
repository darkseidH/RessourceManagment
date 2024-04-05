package com.ressourcemanagement.model;


import jakarta.persistence.Entity;

import java.util.ArrayList;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:22 AM
 */
@Entity
public class Enseignant extends User {
    private long inDepartment;
    private ArrayList<RessourceMaterielle> materiels;
}//end Ensignant