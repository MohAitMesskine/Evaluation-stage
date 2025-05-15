package com.example.evaluation.model;

import jakarta.persistence.Entity;

@Entity
public class Tuteur extends Personne {
    private String entreprise;

    // Getters and Setters
    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }
}