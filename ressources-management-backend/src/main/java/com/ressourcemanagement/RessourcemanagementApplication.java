package com.ressourcemanagement;

import com.ressourcemanagement.model.Departement;
import com.ressourcemanagement.model.Enseignant;
import com.ressourcemanagement.repository.DepartementRepository;
import com.ressourcemanagement.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class RessourcemanagementApplication implements CommandLineRunner {
public class RessourcemanagementApplication {
//    @Autowired
//    DepartementRepository departementRepository;
//    @Autowired
//    EnseignantRepository enseigantRepository;

    public static void main(String[] args) {
        SpringApplication.run(RessourcemanagementApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Departement departement = new Departement().builder().nom("Physics").build();
//        departementRepository.save(departement);
//        Enseignant enseignant = new Enseignant().builder()
//                .email("chaqchaq9@gmail.com")
//                .role("enseigant")
//                .nom("Chaqchaq")
//                .password("ham147532@")
//                .prenom("Hamza")
//                .departement(departement)
//                .build();
//        enseigantRepository.save(enseignant);
//    }
}
