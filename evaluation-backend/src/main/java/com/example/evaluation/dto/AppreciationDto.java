package com.example.evaluation.dto;

import java.util.List;

public class AppreciationDto {
    private Long idTuteur;
    private Long idStage;
    private Long idStagiaire;

    private List<EvaluationDto> evaluations;
    private List<CompetenceDto> competences;

    // Getters and Setters

    public Long getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Long idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Long getIdStage() {
        return idStage;
    }

    public void setIdStage(Long idStage) {
        this.idStage = idStage;
    }

    public Long getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(Long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public List<EvaluationDto> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<EvaluationDto> evaluations) {
        this.evaluations = evaluations;
    }

    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }

    private Integer noteIndividu;
    private Integer noteEntreprise;
    private Integer noteScientifique;

    private List<CompetenceIndividuDTO> competencesIndividu;
    private List<CompetenceEntrepriseDTO> competencesEntreprise;
    private List<CompetenceScientifiqueDTO> competencesScientifique;
    private List<CompetenceMetierDTO> competencesMetier;

    public Integer getNoteIndividu() {
        return noteIndividu;
    }

    public void setNoteIndividu(Integer noteIndividu) {
        this.noteIndividu = noteIndividu;
    }

    public Integer getNoteEntreprise() {
        return noteEntreprise;
    }

    public void setNoteEntreprise(Integer noteEntreprise) {
        this.noteEntreprise = noteEntreprise;
    }

    public Integer getNoteScientifique() {
        return noteScientifique;
    }

    public void setNoteScientifique(Integer noteScientifique) {
        this.noteScientifique = noteScientifique;
    }

    public List<CompetenceIndividuDTO> getCompetencesIndividu() {
        return competencesIndividu;
    }

    public void setCompetencesIndividu(List<CompetenceIndividuDTO> competencesIndividu) {
        this.competencesIndividu = competencesIndividu;
    }

    public List<CompetenceEntrepriseDTO> getCompetencesEntreprise() {
        return competencesEntreprise;
    }

    public void setCompetencesEntreprise(List<CompetenceEntrepriseDTO> competencesEntreprise) {
        this.competencesEntreprise = competencesEntreprise;
    }

    public List<CompetenceScientifiqueDTO> getCompetencesScientifique() {
        return competencesScientifique;
    }

    public void setCompetencesScientifique(List<CompetenceScientifiqueDTO> competencesScientifique) {
        this.competencesScientifique = competencesScientifique;
    }

    public List<CompetenceMetierDTO> getCompetencesMetier() {
        return competencesMetier;
    }

    public void setCompetencesMetier(List<CompetenceMetierDTO> competencesMetier) {
        this.competencesMetier = competencesMetier;
    }
}
