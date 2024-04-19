package com.ressourcemanagement;

import com.ressourcemanagement.model.Ordinateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class TestMain implements CommandLineRunner {
    //    @Autowired
//    DepartementRepository departementRepository;
//    @Autowired
//    EnseignantRepository enseigantRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
    //    @Autowired
//    PanneRepository panneRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    OrdinateurRepository ordinateurRepository;
//    @Autowired
//    ResponsableRepository responsableRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Responsable responsable = new Responsable().builder()
//                .email("chaqchaq.hamza@proton.me")
//                .role(UsersRoles.RESPONSABLE)
//                .nom("Chaqchaq")
//                .prenom("Hamza")
//                .password(passwordEncoder.encode("12345"))
//                .build();

//        Technicien technicien = new Technicien().builder().email("test@example.org")
//                .password(passwordEncoder.encode("12345"))
//                .role(UsersRoles.TECHNICIEN)
//                .nom("Chaqchaq")
//                .prenom("Hamza")
//                .build();
//        Departement departement = new Departement().builder().nom("Computer Science").build();
        Ordinateur ordinateur1 = Ordinateur.builder()
                .cpu("intel i9")
                .ram("16 gb")
                .disk("1 tb")
                .barCode(2)
                .build();
        Ordinateur ordinateur2 = Ordinateur.builder()
                .cpu("intel i7")
                .ram("8 gb")
                .disk("256 gb")
                .barCode(3)
                .build();


//        Enseignant enseignant = new Enseignant().builder()
//                .email("chaqchaq9@gmail.com")
//                .role(UsersRoles.ENSEIGNANT)
//                .nom("Chaqchaq")
//                .prenom("Hamza")
//                .password(passwordEncoder.encode("12345"))
//                .departement(departement)
//                .vitesseImpression(300)
//                .build();
//        imprimanteRepository.save(imprimante);
//
////        Responsable responsable = new Responsable().builder()
////                .email("chaqchaq.hamza@proton.me")
////                .role(UsersRoles.RESPONSABLE)
////                .nom("Chaqchaq")
////                .prenom("Hamza")
////                .password(passwordEncoder.encode("12345"))
////                .build();
//
////        Technicien technicien = new Technicien().builder().email("test@example.org")
////                .password(passwordEncoder.encode("12345"))
////                .role(UsersRoles.TECHNICIEN)
////                .nom("Chaqchaq")
////                .prenom("Hamza")
////                .build();
////        Departement departement = new Departement().builder().nom("physics").build();
//
////        Ordinateur ordinateur1 = new Ordinateur().builder()
////                .cpu("intel i9")
////                .ram("16 gb")
////                .disk("1 tb")
////                .barCode(2)
////                .departement(departement)
////                .build();
////        Ordinateur ordinateur2 = new Ordinateur().builder()
////                .cpu("intel i7")
////                .ram("8 gb")
////                .disk("256 gb")
////                .barCode(3)
////                .departement(departement)
////                .build();
////        Enseignant enseignant = new Enseignant().builder()
////                .email("enseignant1@gmail.com")
////                .role(UsersRoles.ENSEIGNANT)
////                .nom("Enseignant")
////                .prenom("1")
////                .password(passwordEncoder.encode("12345"))
////                .departement(departement)
////                .build();
////
////        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
////
////
////        Panne panne1 = new Panne().builder()
////                .dateApparition(date)
////                .demanderChanger(false)
////                .demanderReparer(false)
////                .frequence(PanneFrequence.RARE)
////                .explication("panne de la salle 3")
////                .ordre(PaneOrder.SYSTEM)
////                .ressources(ordinateur1)
////                .technicien(technicien)
////                .build();
////
////        Panne panne2 = new Panne().builder()
////                .dateApparition(date)
////                .demanderChanger(false)
////                .demanderReparer(false)
////                .frequence(PanneFrequence.PERMANANTE)
////                .explication("panne de la salle 4")
////                .ordre(PaneOrder.SYSTEM)
////                .ressources(ordinateur2)
////                .technicien(technicien)
////                .build();
//
//        Panne panne1 = new Panne().builder()
//                .dateApparition(date)
//                .demanderChanger(false)
//                .demanderReparer(false)
//                .frequence(PanneFrequence.RARE)
//                .explication("panne de la salle 3")
//                .ordre(PaneOrder.SYSTEM)
//                .ressources(ordinateur1)
//                .technicien(technicien)
//                .build();
//
//        Panne panne2 = new Panne().builder()
//                .dateApparition(date)
//                .demanderChanger(false)
//                .demanderReparer(false)
//                .frequence(PanneFrequence.PERMANANTE)
//                .explication("panne de la salle 4")
//                .ordre(PaneOrder.SYSTEM)
//                .ressources(ordinateur2)
//                .technicien(technicien)
//                .build();

//        responsableRepository.save(responsable);
//        userRepository.save(technicien);
//        departementRepository.save(departement);
//        ordinateurRepository.save(ordinateur1);
//        ordinateurRepository.save(ordinateur2);
//        enseigantRepository.save(enseignant);
//        panneRepository.save(panne1);
//        panneRepository.save(panne2);


    }
}
