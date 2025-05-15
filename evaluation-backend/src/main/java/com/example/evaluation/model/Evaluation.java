package com.example.evaluation.model;

import jakarta.persistence.*;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categorie;
    private String valeur;

    @Enumerated(EnumType.STRING)
    private Activite activite;

    @Enumerated(EnumType.STRING)
    private Ouverture ouverture;

    @Enumerated(EnumType.STRING)
    private Qualite qualite;

    private String observation;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_stage", referencedColumnName = "idStage"),
            @JoinColumn(name = "id_stagiaire", referencedColumnName = "idStagiaire")
    })
    private Periode periode;

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

}
