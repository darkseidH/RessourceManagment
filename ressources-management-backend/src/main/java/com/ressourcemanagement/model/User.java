package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:40 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public abstract class User {
    protected String email;
    protected String role;
    protected String nom;
    protected String password;
    protected String prenom;
    @Id
    private Long id;
}//end User