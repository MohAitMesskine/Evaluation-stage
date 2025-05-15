package com.example.evaluation.dto;

import com.example.evaluation.model.Activite;
import com.example.evaluation.model.Ouverture;
import com.example.evaluation.model.Qualite;

public class EvaluationDto {
    private Long id;
    private String categorie;
    private String valeur;
    private Activite activite;
    private Ouverture ouverture;
    private Qualite qualite;
    private String observation;
    private PeriodeDto periode; // 👈 Ajouté

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public String getValeur() { return valeur; }
    public void setValeur(String valeur) { this.valeur = valeur; }

    public Activite getActivite() { return activite; }
    public void setActivite(Activite activite) { this.activite = activite; }

    public Ouverture getOuverture() { return ouverture; }
    public void setOuverture(Ouverture ouverture) { this.ouverture = ouverture; }

    public Qualite getQualite() { return qualite; }
    public void setQualite(Qualite qualite) { this.qualite = qualite; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public PeriodeDto getPeriode() { return periode; }
    public void setPeriode(PeriodeDto periode) { this.periode = periode; }
}
