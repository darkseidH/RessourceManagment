package com.ressourcemanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:22 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public class Enseignant extends User implements UserDetails {
    @OneToMany(mappedBy = "enseignant")
    private List<RessourceMaterielle> ressources;
    @ManyToOne
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> getRole().name());
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}//end Ensignant