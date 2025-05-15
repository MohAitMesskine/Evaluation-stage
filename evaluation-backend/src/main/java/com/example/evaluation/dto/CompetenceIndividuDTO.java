package com.example.evaluation.dto;

public class CompetenceIndividuDTO {
    private Long id;
    private Integer note;
    private String analyseSynthese; // String pour être mappé aux énumérations
    private String proposerMethodesAxes;
    private String faireAdhererActeurs;
    private String autoEvaluation;
    private String identifierProblemesComplexes;
    private Long appreciationIdTuteur;
    private Long appreciationIdPeriode;

    // Getters et setters...

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

    public String getAnalyseSynthese() {
        return analyseSynthese;
    }

    public void setAnalyseSynthese(String analyseSynthese) {
        this.analyseSynthese = analyseSynthese;
    }

    public String getProposerMethodesAxes() {
        return proposerMethodesAxes;
    }

    public void setProposerMethodesAxes(String proposerMethodesAxes) {
        this.proposerMethodesAxes = proposerMethodesAxes;
    }

    public String getFaireAdhererActeurs() {
        return faireAdhererActeurs;
    }

    public void setFaireAdhererActeurs(String faireAdhererActeurs) {
        this.faireAdhererActeurs = faireAdhererActeurs;
    }

    public String getAutoEvaluation() {
        return autoEvaluation;
    }

    public void setAutoEvaluation(String autoEvaluation) {
        this.autoEvaluation = autoEvaluation;
    }

    public String getIdentifierProblemesComplexes() {
        return identifierProblemesComplexes;
    }

    public void setIdentifierProblemesComplexes(String identifierProblemesComplexes) {
        this.identifierProblemesComplexes = identifierProblemesComplexes;
    }

    public Long getAppreciationIdTuteur() {
        return appreciationIdTuteur;
    }

    public void setAppreciationIdTuteur(Long appreciationIdTuteur) {
        this.appreciationIdTuteur = appreciationIdTuteur;
    }

    public Long getAppreciationIdPeriode() {
        return appreciationIdPeriode;
    }

    public void setAppreciationIdPeriode(Long appreciationIdPeriode) {
        this.appreciationIdPeriode = appreciationIdPeriode;
    }
}
