package com.ressourcemanagement.service;

import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.enumeration.UsersRoles;
import com.ressourcemanagement.model.Departement;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.repository.DepartementRepository;
import com.ressourcemanagement.repository.EnseignantRepository;
import com.ressourcemanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private DepartementRepository departementRepository;
    private EnseignantRepository enseignantRepositiry;
    private UserRepository userRepository;

    public String register(UserDto user) {
        Departement departement = new Departement().builder().nom("Physics").build();
        departementRepository.save(departement);
        Enseignant enseignant =
                new Enseignant().builder()
                        .email(user.getEmail())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .departement(departement)
                        .role(UsersRoles.valueOf(UsersRoles.ENSEIGNANT.name()))
                        .build();
        System.out.println(enseignant.toString());
        enseignantRepositiry.save(enseignant);
        System.out.println("User added successfully");
        return "User added successfully";
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
