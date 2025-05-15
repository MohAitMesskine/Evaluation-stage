package com.example.evaluation.model;

import jakarta.persistence.*;

@Entity
public class CompetenceScientifique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Enumération pour les produits/services/processus/usages, utilisant l'énumération Niveau
    @Enumerated(EnumType.STRING)
    private Niveau produitsServicesProcessusUsages;

    // Note sur 20 pour évaluer les compétences scientifiques
    private Integer note;

    // Relation vers l'appréciation
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_tuteur", referencedColumnName = "idTuteur"),
            @JoinColumn(name = "id_periode", referencedColumnName = "idPeriode")
    })
    private Appreciation appreciation;


    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Niveau getProduitsServicesProcessusUsages() {
        return produitsServicesProcessusUsages;
    }

    public void setProduitsServicesProcessusUsages(Niveau produitsServicesProcessusUsages) {
        this.produitsServicesProcessusUsages = produitsServicesProcessusUsages;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }
}
