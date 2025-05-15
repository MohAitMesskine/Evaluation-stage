package com.example.evaluation.model;

import jakarta.persistence.*;

@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String objectif;
    private String entreprise;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stagiaire_id")
    private Stagiaire stagiaire;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getObjectif() { return objectif; }
    public void setObjectif(String objectif) { this.objectif = objectif; }

    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }



    public Stagiaire getStagiaire() { return stagiaire; }
    public void setStagiaire(Stagiaire stagiaire) { this.stagiaire = stagiaire; }
}