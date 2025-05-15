package com.example.evaluation.dto;

import java.time.LocalDate;

public class PeriodeDto {
    private PeriodeIdDto id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    // Getters and Setters
    // ...

    public PeriodeIdDto getId() {
        return id;
    }

    public void setId(PeriodeIdDto id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}