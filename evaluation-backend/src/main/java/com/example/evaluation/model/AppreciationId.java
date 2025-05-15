package com.example.evaluation.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppreciationId implements Serializable {
    private Long idTuteur;
    private Long idPeriode;

    public AppreciationId() {
    }

    public AppreciationId(Long idTuteur, Long idPeriode) {
        this.idTuteur = idTuteur;
        this.idPeriode = idPeriode;
    }

    public Long getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Long idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Long getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Long idPeriode) {
        this.idPeriode = idPeriode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppreciationId)) return false;
        AppreciationId that = (AppreciationId) o;
        return Objects.equals(idTuteur, that.idTuteur) &&
                Objects.equals(idPeriode, that.idPeriode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTuteur, idPeriode);
    }
}