package com.example.evaluation.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Periode {
    @EmbeddedId
    private PeriodeId id;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Getters and Setters
    public PeriodeId getId() { return id; }
    public void setId(PeriodeId id) { this.id = id; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
}