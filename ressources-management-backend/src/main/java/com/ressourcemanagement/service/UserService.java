package com.ressourcemanagement.service;

import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.enumeration.UsersRoles;
import com.ressourcemanagement.model.*;
import com.ressourcemanagement.repository.DepartementRepository;
import com.ressourcemanagement.repository.EnseignantRepository;
import com.ressourcemanagement.repository.FournisseurRepository;
import com.ressourcemanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private DepartementRepository departementRepository;
    private EnseignantRepository enseignantRepositiry;
    private UserRepository userRepository;
    private FournisseurRepository fournisseurRepository;

    public void register(UserDto user) {
        Fournisseur fournisseur = Fournisseur.builder()
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(UsersRoles.FOURNISSEUR)
                .build();
        fournisseurRepository.save(fournisseur);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, UserDto user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setNom(user.getNom());
            userToUpdate.setPrenom(user.getPrenom());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
            userToUpdate.setRole(userToUpdate.getRole());
            userRepository.save(userToUpdate);
        }
    }

    public void addUser(UserDto user) {
        if (user.getRole().equals("0")) {
            Departement departement = departementRepository.findById(user.getDepartement_id()).orElse(null);
            new Enseignant();
            Enseignant enseignant = Enseignant.builder()
                    .nom(user.getNom())
                    .prenom(user.getPrenom())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .departement(departement)
                    .role(UsersRoles.ENSEIGNANT)
                    .build();
            enseignantRepositiry.save(enseignant);
        } else if (user.getRole().equals("1")) {
            Departement departement = departementRepository.findById(user.getDepartement_id()).orElse(null);
            new Enseignant();
            Enseignant enseignant = Enseignant.builder()
                    .nom(user.getNom())
                    .prenom(user.getPrenom())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .role(UsersRoles.ENSEIGNANT)
                    .departement(departement)
                    .build();
            enseignantRepositiry.save(enseignant);
            enseignant = enseignantRepositiry.findByEmail(user.getEmail());
            assert departement != null;
            departement.setEnseignant(enseignant);
            departementRepository.save(departement);
        } else {
            new Technicien();
            Technicien technicien = Technicien.builder()
                    .nom(user.getNom())
                    .prenom(user.getPrenom())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .role(UsersRoles.TECHNICIEN)
                    .build();
            userRepository.save(technicien);
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
