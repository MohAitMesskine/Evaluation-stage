package com.example.evaluation.dto;

import com.example.evaluation.model.Niveau;

public class CompetenceMetierDTO {

    private Long id;

    private String competence1;
    private Niveau niveau1;

    private String competence2;
    private Niveau niveau2;

    private String competence3;
    private Niveau niveau3;

    private String competence4;
    private Niveau niveau4;

    private String competence5;
    private Niveau niveau5;

    private Long appreciationIdTuteur;
    private Long appreciationIdPeriode;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetence1() {
        return competence1;
    }

    public void setCompetence1(String competence1) {
        this.competence1 = competence1;
    }

    public Niveau getNiveau1() {
        return niveau1;
    }

    public void setNiveau1(Niveau niveau1) {
        this.niveau1 = niveau1;
    }

    public String getCompetence2() {
        return competence2;
    }

    public void setCompetence2(String competence2) {
        this.competence2 = competence2;
    }

    public Niveau getNiveau2() {
        return niveau2;
    }

    public void setNiveau2(Niveau niveau2) {
        this.niveau2 = niveau2;
    }

    public String getCompetence3() {
        return competence3;
    }

    public void setCompetence3(String competence3) {
        this.competence3 = competence3;
    }

    public Niveau getNiveau3() {
        return niveau3;
    }

    public void setNiveau3(Niveau niveau3) {
        this.niveau3 = niveau3;
    }

    public String getCompetence4() {
        return competence4;
    }

    public void setCompetence4(String competence4) {
        this.competence4 = competence4;
    }

    public Niveau getNiveau4() {
        return niveau4;
    }

    public void setNiveau4(Niveau niveau4) {
        this.niveau4 = niveau4;
    }

    public String getCompetence5() {
        return competence5;
    }

    public void setCompetence5(String competence5) {
        this.competence5 = competence5;
    }

    public Niveau getNiveau5() {
        return niveau5;
    }

    public void setNiveau5(Niveau niveau5) {
        this.niveau5 = niveau5;
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
