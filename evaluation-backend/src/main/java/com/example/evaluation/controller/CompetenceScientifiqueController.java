package com.example.evaluation.controller;

import com.example.evaluation.dto.CompetenceScientifiqueDTO;
import com.example.evaluation.service.CompetenceScientifiqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences-scientifiques")
public class CompetenceScientifiqueController {

    private final CompetenceScientifiqueService competenceScientifiqueService;

    public CompetenceScientifiqueController(CompetenceScientifiqueService competenceScientifiqueService) {
        this.competenceScientifiqueService = competenceScientifiqueService;
    }

    // Endpoint pour ajouter une compétence scientifique
    @PostMapping
    public ResponseEntity<CompetenceScientifiqueDTO> createCompetenceScientifique(@RequestBody CompetenceScientifiqueDTO dto) {
        CompetenceScientifiqueDTO savedCompetence = competenceScientifiqueService.save(dto);
        return new ResponseEntity<>(savedCompetence, HttpStatus.CREATED);
    }

    // Endpoint pour obtenir toutes les compétences scientifiques
    @GetMapping
    public ResponseEntity<List<CompetenceScientifiqueDTO>> getAllCompetencesScientifiques() {
        List<CompetenceScientifiqueDTO> competences = competenceScientifiqueService.findAll();
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    // Endpoint pour obtenir une compétence scientifique par son ID
    @GetMapping("/{id}")
    public ResponseEntity<CompetenceScientifiqueDTO> getCompetenceScientifiqueById(@PathVariable Long id) {
        CompetenceScientifiqueDTO competence = competenceScientifiqueService.findById(id);
        return new ResponseEntity<>(competence, HttpStatus.OK);
    }

    // Endpoint pour supprimer une compétence scientifique par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetenceScientifique(@PathVariable Long id) {
        competenceScientifiqueService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
