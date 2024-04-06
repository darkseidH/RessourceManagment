package com.ressourcemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class RessourcemanagementApplication implements CommandLineRunner {
public class RessourcemanagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(RessourcemanagementApplication.class, args);
	}

//	@Autowired
//	DepartementRepository departementRepository;
//	@Autowired
//	EnseigantRepository enseigantRepository;

//	@Override
//	public void run(String... args) throws Exception {
//		Departement departement = new Departement().builder().nom("Physics").build();
//		departementRepository.save(departement);
//		Enseignant enseignant = new Enseignant().builder()
//				.email("chaqchaq9@gmail.com")
//				.role("enseigant")
//				.nom("Chaqchaq")
//				.password("ham147532@")
//				.prenom("Hamza")
//				.departement(departement)
//				.build();
//		enseigantRepository.save(enseignant);
//	}
}
