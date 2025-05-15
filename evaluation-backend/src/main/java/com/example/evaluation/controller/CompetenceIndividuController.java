package com.example.evaluation.controller;

import com.example.evaluation.dto.CompetenceIndividuDTO;
import com.example.evaluation.service.CompetenceIndividuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences-individu")
public class CompetenceIndividuController {

    private final CompetenceIndividuService service;

    public CompetenceIndividuController(CompetenceIndividuService service) {
        this.service = service;
    }

    @PostMapping
    public CompetenceIndividuDTO create(@RequestBody CompetenceIndividuDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<CompetenceIndividuDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CompetenceIndividuDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
