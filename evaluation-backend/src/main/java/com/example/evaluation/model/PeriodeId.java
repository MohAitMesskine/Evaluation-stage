package com.example.evaluation.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PeriodeId implements Serializable {
    private Long idStage;
    private Long idStagiaire;

    // Getters and Setters
    public Long getIdStage() { return idStage; }
    public void setIdStage(Long idStage) { this.idStage = idStage; }

    public Long getIdStagiaire() { return idStagiaire; }
    public void setIdStagiaire(Long idStagiaire) { this.idStagiaire = idStagiaire; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodeId that = (PeriodeId) o;
        return Objects.equals(idStage, that.idStage) &&
                Objects.equals(idStagiaire, that.idStagiaire);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idStage, idStagiaire);
    }
}