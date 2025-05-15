package com.example.evaluation.dto;

import java.util.List;

public class AppreciationRequest {

    private int noteIndividu;
    private int noteEntreprise;
    private int noteScientifique;
    private List<CompetenceDto> competencesIndividu;
    private List<CompetenceDto> competencesEntreprise;
    private List<CompetenceScientifiqueDto> competencesScientifique;
    private List<CompetenceMetierDto> competencesMetier;

    // getters et setters

    public int getNoteIndividu() {
        return noteIndividu;
    }

    public void setNoteIndividu(int noteIndividu) {
        this.noteIndividu = noteIndividu;
    }

    public int getNoteEntreprise() {
        return noteEntreprise;
    }

    public void setNoteEntreprise(int noteEntreprise) {
        this.noteEntreprise = noteEntreprise;
    }

    public int getNoteScientifique() {
        return noteScientifique;
    }

    public void setNoteScientifique(int noteScientifique) {
        this.noteScientifique = noteScientifique;
    }

    public List<CompetenceDto> getCompetencesIndividu() {
        return competencesIndividu;
    }

    public void setCompetencesIndividu(List<CompetenceDto> competencesIndividu) {
        this.competencesIndividu = competencesIndividu;
    }

    public List<CompetenceDto> getCompetencesEntreprise() {
        return competencesEntreprise;
    }

    public void setCompetencesEntreprise(List<CompetenceDto> competencesEntreprise) {
        this.competencesEntreprise = competencesEntreprise;
    }

    public List<CompetenceScientifiqueDto> getCompetencesScientifique() {
        return competencesScientifique;
    }

    public void setCompetencesScientifique(List<CompetenceScientifiqueDto> competencesScientifique) {
        this.competencesScientifique = competencesScientifique;
    }

    public List<CompetenceMetierDto> getCompetencesMetier() {
        return competencesMetier;
    }

    public void setCompetencesMetier(List<CompetenceMetierDto> competencesMetier) {
        this.competencesMetier = competencesMetier;
    }

    // DTO internes
    public static class CompetenceDto {
        private String intitule;
        private String niveau;
        private int note;

        // getters et setters


        public int getNote() {
            return note;
        }

        public void setNote(int note) {
            this.note = note;
        }

        public String getIntitule() {
            return intitule;
        }

        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }

        public String getNiveau() {
            return niveau;
        }

        public void setNiveau(String niveau) {
            this.niveau = niveau;
        }
    }

    public static class CompetenceScientifiqueDto {
        private String description;
        private int note ;


        // getters et setters

        public int getNote() {
            return note;
        }

        public void setNote(int note) {
            this.note = note;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }




    }

    public static class CompetenceMetierDto {
        private String description;
        private int note ;

        public int getNote() {
            return note;
        }

        public void setNote(int note) {
            this.note = note;
        }
        // getters et setters


        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }




    }
}
