package com.example.evaluation.dto;

import com.example.evaluation.model.IntituleEntreprise;
import com.example.evaluation.model.Niveau;
import lombok.Data;

@Data
public class CompetenceEntrepriseDTO {
    private IntituleEntreprise intituleEntreprise;
    private Integer note;
    private Niveau analyseFonctionnementEntreprise;
    private Niveau analyseDemarcheProjet;
    private Niveau comprehensionPolitiqueEnvironnementale;
    private Niveau rechercheEtSelectionInformation;
    private Long appreciationIdTuteur;
    private Long appreciationIdPeriode;


    public IntituleEntreprise getIntituleEntreprise() {
        return intituleEntreprise;
    }

    public void setIntituleEntreprise(IntituleEntreprise intituleEntreprise) {
        this.intituleEntreprise = intituleEntreprise;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Niveau getAnalyseFonctionnementEntreprise() {
        return analyseFonctionnementEntreprise;
    }

    public void setAnalyseFonctionnementEntreprise(Niveau analyseFonctionnementEntreprise) {
        this.analyseFonctionnementEntreprise = analyseFonctionnementEntreprise;
    }

    public Niveau getAnalyseDemarcheProjet() {
        return analyseDemarcheProjet;
    }

    public void setAnalyseDemarcheProjet(Niveau analyseDemarcheProjet) {
        this.analyseDemarcheProjet = analyseDemarcheProjet;
    }

    public Niveau getComprehensionPolitiqueEnvironnementale() {
        return comprehensionPolitiqueEnvironnementale;
    }

    public void setComprehensionPolitiqueEnvironnementale(Niveau comprehensionPolitiqueEnvironnementale) {
        this.comprehensionPolitiqueEnvironnementale = comprehensionPolitiqueEnvironnementale;
    }

    public Niveau getRechercheEtSelectionInformation() {
        return rechercheEtSelectionInformation;
    }

    public void setRechercheEtSelectionInformation(Niveau rechercheEtSelectionInformation) {
        this.rechercheEtSelectionInformation = rechercheEtSelectionInformation;
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
