package com.example.evaluation.controller;

import com.example.evaluation.dto.*;
import com.example.evaluation.service.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/stagiaire-stage")
public class StagiaireStageController {
    @Autowired private StagiaireService stagiaireService;
    @Autowired private StageService stageService;
    @Autowired private PeriodeService periodeService;
    @Autowired private TuteurService tuteurService;

    @Transactional
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody StagiaireStageRequest req) {
        StagiaireDto s = new StagiaireDto();
        s.setNom(req.getNom());
        s.setPrenom(req.getPrenom());
        s.setEmail(req.getEmail());
        s.setInstitution(req.getInstitution());
        StagiaireDto savedS = stagiaireService.save(s);

        TuteurDto t = new TuteurDto();
        t.setNom(req.getNomT());
        t.setPrenom(req.getPrenomT());
        t.setEmail(req.getEmailT());
        t.setEntreprise(req.getEntreprise());
        tuteurService.save(t);


        StageDto st = new StageDto();
        st.setDescription(req.getDescription());
        st.setObjectif(req.getObjectif());
        st.setEntreprise(req.getEntreprise());

        st.setStagiaire(savedS);
        StageDto savedSt = stageService.save(st);

        PeriodeIdDto pid = new PeriodeIdDto();
        pid.setIdStagiaire(savedS.getId());
        pid.setIdStage(savedSt.getId());
        PeriodeDto p = new PeriodeDto();
        p.setId(pid);
        p.setDateDebut(req.getDateDebut());
        p.setDateFin(req.getDateFin());
        periodeService.save(p);

        return ResponseEntity.ok("Enregistré avec succès.");
    }

    public static class StagiaireStageRequest {
        private String nom, prenom, email, institution;
        private String description, objectif, entreprise;

        private String nomT, prenomT, emailT;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateDebut;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateFin;
        // getters/setters

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getInstitution() {
            return institution;
        }

        public void setInstitution(String institution) {
            this.institution = institution;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getObjectif() {
            return objectif;
        }

        public void setObjectif(String objectif) {
            this.objectif = objectif;
        }

        public String getEntreprise() {
            return entreprise;
        }

        public void setEntreprise(String entreprise) {
            this.entreprise = entreprise;
        }

        public String getNomT() {
            return nomT;
        }

        public void setNomT(String nomT) {
            this.nomT = nomT;
        }

        public String getPrenomT() {
            return prenomT;
        }

        public void setPrenomT(String prenomT) {
            this.prenomT = prenomT;
        }

        public String getEmailT() {
            return emailT;
        }

        public void setEmailT(String emailT) {
            this.emailT = emailT;
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
}
