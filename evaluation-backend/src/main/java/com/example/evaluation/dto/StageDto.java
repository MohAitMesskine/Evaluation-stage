package com.example.evaluation.dto;

public class StageDto {
    private Long id;
    private String description;
    private String objectif;
    private String entreprise;

    private StagiaireDto stagiaire;
    // Getters and Setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }



    public StagiaireDto getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(StagiaireDto stagiaire) {
        this.stagiaire = stagiaire;
    }
}