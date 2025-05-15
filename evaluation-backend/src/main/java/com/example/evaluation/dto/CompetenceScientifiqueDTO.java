package com.example.evaluation.dto;

import com.example.evaluation.model.Niveau;

public class CompetenceScientifiqueDTO {

    private Long id;
    private Niveau produitsServicesProcessusUsages;
    private Integer note;
    private Long appreciationIdTuteur;
    private Long appreciationIdPeriode;

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
