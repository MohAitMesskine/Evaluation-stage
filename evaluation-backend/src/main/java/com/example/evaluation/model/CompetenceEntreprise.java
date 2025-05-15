package com.example.evaluation.model;

import jakarta.persistence.*;

@Entity
public class CompetenceEntreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IntituleEntreprise intituleEntreprise;

    private Integer note;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_tuteur", referencedColumnName = "idTuteur"),
            @JoinColumn(name = "id_periode", referencedColumnName = "idPeriode")
    })
    private Appreciation appreciation;

    // 🔥 Les 4 nouvelles compétences liées à l'entreprise
    @Enumerated(EnumType.STRING)
    private Niveau analyseFonctionnementEntreprise;

    @Enumerated(EnumType.STRING)
    private Niveau analyseDemarcheProjet;

    @Enumerated(EnumType.STRING)
    private Niveau comprehensionPolitiqueEnvironnementale;

    @Enumerated(EnumType.STRING)
    private Niveau rechercheEtSelectionInformation;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public IntituleEntreprise getIntituleEntreprise() { return intituleEntreprise; }
    public void setIntituleEntreprise(IntituleEntreprise intituleEntreprise) { this.intituleEntreprise = intituleEntreprise; }

    public Integer getNote() { return note; }
    public void setNote(Integer note) { this.note = note; }

    public Appreciation getAppreciation() { return appreciation; }
    public void setAppreciation(Appreciation appreciation) { this.appreciation = appreciation; }

    public Niveau getAnalyseFonctionnementEntreprise() { return analyseFonctionnementEntreprise; }
    public void setAnalyseFonctionnementEntreprise(Niveau analyseFonctionnementEntreprise) { this.analyseFonctionnementEntreprise = analyseFonctionnementEntreprise; }

    public Niveau getAnalyseDemarcheProjet() {
        return analyseDemarcheProjet;
    }

    public void setAnalyseDemarcheProjet(Niveau analyseDemarcheProjet) {
        this.analyseDemarcheProjet = analyseDemarcheProjet;
    }

    public Niveau getComprehensionPolitiqueEnvironnementale() { return comprehensionPolitiqueEnvironnementale; }
    public void setComprehensionPolitiqueEnvironnementale(Niveau comprehensionPolitiqueEnvironnementale) { this.comprehensionPolitiqueEnvironnementale = comprehensionPolitiqueEnvironnementale; }

    public Niveau getRechercheEtSelectionInformation() { return rechercheEtSelectionInformation; }
    public void setRechercheEtSelectionInformation(Niveau rechercheEtSelectionInformation) { this.rechercheEtSelectionInformation = rechercheEtSelectionInformation; }
}

