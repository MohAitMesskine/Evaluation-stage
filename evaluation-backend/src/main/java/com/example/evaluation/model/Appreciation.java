package com.example.evaluation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Appreciation {
    @EmbeddedId
    private AppreciationId id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Competence> competences = new ArrayList<>();
    @OneToMany(mappedBy = "appreciation", cascade = CascadeType.ALL)
    private List<CompetenceEntreprise> competencesEntreprise = new ArrayList<>();
    public List<CompetenceEntreprise> getCompetencesEntreprise() {
        return competencesEntreprise;
    }

    public void setCompetencesEntreprise(List<CompetenceEntreprise> competencesEntreprise) {
        this.competencesEntreprise = competencesEntreprise;
    }

    // Getters and Setters
    public AppreciationId getId() { return id; }
    public void setId(AppreciationId id) { this.id = id; }
    public List<Evaluation> getEvaluations() { return evaluations; }
    public void setEvaluations(List<Evaluation> evaluations) { this.evaluations = evaluations; }
    public List<Competence> getCompetences() { return competences; }
    public void setCompetences(List<Competence> competences) { this.competences = competences; }
}
