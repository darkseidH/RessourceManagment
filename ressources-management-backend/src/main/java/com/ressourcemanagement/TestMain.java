package com.ressourcemanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class TestMain implements CommandLineRunner {
    //    @Autowired
//    private OrdinateurRepository ordinateurRepository;
//    @Autowired
//    DepartementRepository departementRepository;
//    @Autowired
//    EnseignantRepository enseigantRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    private FournisseurRepository fournisseurRepository;
//    @Autowired
//    PanneRepository panneRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    private AppelOffreRepository appelOffreRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    ResponsableRepository responsableRepository;
//
    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    //
    @Override
    public void run(String... args) throws Exception {
//        Responsable responsable = new Responsable().builder()
//                .email("chaqchaq.hamza@proton.me")
//                .role(UsersRoles.RESPONSABLE)
//                .nom("Chaqchaq")
//                .prenom("Hamza")
//                .password(passwordEncoder.encode("12345"))
//                .build();
//        Fournisseur fournisseur = Fournisseur.builder()
//                .prenom("Adrae")
//                .nom("Benani")
//                .email("test2@exemple.org")
//                .password(passwordEncoder.encode("12345"))
//                .role(UsersRoles.FOURNISSEUR)
//                .build();
//
//        fournisseurRepository.save(fournisseur);

//        Technicien technicien = new Technicien().builder().email("test@example.org")
//                .password(passwordEncoder.encode("12345"))
//                .role(UsersRoles.TECHNICIEN)
//                .nom("Chaqchaq")
//                .prenom("Hamza")
//                .build();
//        Departement departement = new Departement().builder().nom("Computer Science").build();

//        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
//        AppelOffre appelOffre = AppelOffre.builder()
//                .dateDebut(date)
//                .dateFin(date)
//                .build();
//
//        Ordinateur ordinateur1 = Ordinateur.builder()
//                .cpu("intel i9")
//                .ram("16 gb")
//                .disk("1 tb")
//                .barCode(2)
//                .appelOffre(appelOffre)
//                .build();
//
//        Ordinateur ordinateur2 = Ordinateur.builder()
//                .cpu("intel i7")
//                .ram("8 gb")
//                .disk("256 gb")
//                .barCode(3)
//                .appelOffre(appelOffre)
//                .build();
//
//        appelOffreRepository.save(appelOffre);
//        ordinateurRepository.save(ordinateur1);
//        ordinateurRepository.save(ordinateur2);
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
//        Departement departement = new Departement().builder().nom("physics").build();
//
//        Ordinateur ordinateur1 = new Ordinateur().builder()
//                .cpu("intel i9")
//                .ram("16 gb")
//                .disk("1 tb")
//                .barCode(2)
//                .departement(departement)
//                .build();
//        Ordinateur ordinateur2 = new Ordinateur().builder()
//                .cpu("intel i7")
//                .ram("8 gb")
//                .disk("256 gb")
//                .barCode(3)
//                .departement(departement)
//                .build();
//        Enseignant enseignant = new Enseignant().builder()
//                .email("enseignant1@gmail.com")
//                .role(UsersRoles.ENSEIGNANT)
//                .nom("Enseignant")
//                .prenom("1")
//                .password(passwordEncoder.encode("12345"))
//                .departement(departement)
//                .build();
//
//        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
//
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
