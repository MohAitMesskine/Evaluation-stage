package com.example.evaluation.controller;

import com.example.evaluation.dto.CompetenceEntrepriseDTO;
import com.example.evaluation.service.CompetenceEntrepriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competence-entreprise")

public class CompetenceEntrepriseController {

    private final CompetenceEntrepriseService competenceEntrepriseService;

    public CompetenceEntrepriseController(CompetenceEntrepriseService competenceEntrepriseService) {
        this.competenceEntrepriseService = competenceEntrepriseService;
    }

    @PostMapping
    public ResponseEntity<CompetenceEntrepriseDTO> create(@RequestBody CompetenceEntrepriseDTO dto) {
        CompetenceEntrepriseDTO savedDto = competenceEntrepriseService.save(dto);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping
    public ResponseEntity<List<CompetenceEntrepriseDTO>> getAll() {
        return ResponseEntity.ok(competenceEntrepriseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenceEntrepriseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(competenceEntrepriseService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competenceEntrepriseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
