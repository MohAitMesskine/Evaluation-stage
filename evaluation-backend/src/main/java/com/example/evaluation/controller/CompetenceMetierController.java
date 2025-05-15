package com.example.evaluation.controller;

import com.example.evaluation.dto.CompetenceMetierDTO;
import com.example.evaluation.service.CompetenceMetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences-metier")
public class CompetenceMetierController {

    private final CompetenceMetierService service;

    @Autowired
    public CompetenceMetierController(CompetenceMetierService service) {
        this.service = service;
    }

    @PostMapping
    public CompetenceMetierDTO save(@RequestBody CompetenceMetierDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<CompetenceMetierDTO> getAll() {
        return service.getAll();
    }
}
