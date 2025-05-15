package com.example.evaluation.model;

import jakarta.persistence.Entity;

@Entity
public class Stagiaire extends Personne {
    private String institution;

    // Getters and Setters
    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }
}