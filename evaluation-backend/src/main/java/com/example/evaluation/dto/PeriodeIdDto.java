package com.example.evaluation.dto;

import java.io.Serializable;

public class PeriodeIdDto implements Serializable {
    private Long idStage;
    private Long idStagiaire;
    // Getters and Setters
    // ...

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
}