//package com.ressourcemanagement;
//
//import com.ressourcemanagement.enumeration.RessourceStatus;
//import com.ressourcemanagement.enumeration.UsersRoles;
//import com.ressourcemanagement.model.Departement;
//import com.ressourcemanagement.model.Enseignant;
//import com.ressourcemanagement.model.Imprimante;
//import com.ressourcemanagement.repository.DepartementRepository;
//import com.ressourcemanagement.repository.EnseignantRepository;
//import com.ressourcemanagement.repository.ImprimanteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@SpringBootApplication
//public class TestMain implements CommandLineRunner {
//        @Autowired
//        private DepartementRepository departementRepository;
//        @Autowired
//        private  EnseignantRepository enseigantRepository;
//        @Autowired
//        ImprimanteRepository imprimanteRepository;
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//    //@Autowired
////    PasswordEncoder passwordEncoder;
//    //    @Autowired
////    PanneRepository panneRepository;
////    @Autowired
////    UserRepository userRepository;
////    @Autowired
////    OrdinateurRepository ordinateurRepository;
////    @Autowired
////    ResponsableRepository responsableRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestMain.class, args);
//    }
////
//    @Override
//    public void run(String... args) throws Exception {
//        Enseignant enseignant = enseigantRepository.findById(12L).get();
//        Departement departement = departementRepository.findById(enseignant.getDepartement().getId()).get();
//        Imprimante imprimante = new Imprimante().builder()
//                .marque("asus")
//                .status(RessourceStatus.CREE_PAR_ENSEIGNANT)
//                .enseignant(enseignant)
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
////        responsableRepository.save(responsable);
////        userRepository.save(technicien);
////          departementRepository.save(departement);
////        ordinateurRepository.save(ordinateur1);
////        ordinateurRepository.save(ordinateur2);
////          enseigantRepository.save(enseignant);
//
////          departement = departementRepository.findByNom("physics");
////         departement.setEnseignant(enseignant);
////          departementRepository.save(departement);
////        panneRepository.save(panne1);
////        panneRepository.save(panne2);
//
//    }
//}
