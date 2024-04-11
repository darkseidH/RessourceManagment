package com.ressourcemanagement.model;


import com.ressourcemanagement.enumeration.UsersRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:40 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public abstract class User implements UserDetails {
    private String email;
    private UsersRoles role;
    private String nom;
    private String password;
    private String prenom;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

}//end User