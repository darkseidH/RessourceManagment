package com.ressourcemanagement.model;


import com.ressourcemanagement.enumeration.PaneOrder;
import com.ressourcemanagement.enumeration.PanneFrequence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:33 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Panne {
    private Date dateApparition;
    private boolean demanderChanger;
    private boolean demanderReparer;
    private String explication;
    private PanneFrequence frequence;
    private PaneOrder ordre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "ressource_id", nullable = false)
    private RessourceMaterielle ressources;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technicien_id", nullable = false)
    private Technicien technicien;
}//end Panne