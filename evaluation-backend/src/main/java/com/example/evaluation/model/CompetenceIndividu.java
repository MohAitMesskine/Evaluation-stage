package com.example.evaluation.model;

import jakarta.persistence.*;

@Entity
public class CompetenceIndividu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Note globale sur 20
    private Integer note;

    // Questions de compétences, chacune a une réponse (sous forme d'énumération)
    @Enumerated(EnumType.STRING)
    private Niveau analyseSynthese;

    @Enumerated(EnumType.STRING)
    private Niveau proposerMethodesAxes;

    @Enumerated(EnumType.STRING)
    private Niveau faireAdhererActeurs;

    @Enumerated(EnumType.STRING)
    private Niveau autoEvaluation;

    @Enumerated(EnumType.STRING)
    private Niveau identifierProblemesComplexes;

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

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Niveau getAnalyseSynthese() {
        return analyseSynthese;
    }

    public void setAnalyseSynthese(Niveau analyseSynthese) {
        this.analyseSynthese = analyseSynthese;
    }

    public Niveau getProposerMethodesAxes() {
        return proposerMethodesAxes;
    }

    public void setProposerMethodesAxes(Niveau proposerMethodesAxes) {
        this.proposerMethodesAxes = proposerMethodesAxes;
    }

    public Niveau getFaireAdhererActeurs() {
        return faireAdhererActeurs;
    }

    public void setFaireAdhererActeurs(Niveau faireAdhererActeurs) {
        this.faireAdhererActeurs = faireAdhererActeurs;
    }

    public Niveau getAutoEvaluation() {
        return autoEvaluation;
    }

    public void setAutoEvaluation(Niveau autoEvaluation) {
        this.autoEvaluation = autoEvaluation;
    }

    public Niveau getIdentifierProblemesComplexes() {
        return identifierProblemesComplexes;
    }

    public void setIdentifierProblemesComplexes(Niveau identifierProblemesComplexes) {
        this.identifierProblemesComplexes = identifierProblemesComplexes;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }

}
