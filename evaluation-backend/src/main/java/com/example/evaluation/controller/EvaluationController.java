package com.example.evaluation.controller;

import com.example.evaluation.dto.EvaluationDto;
import com.example.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")

public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public List<EvaluationDto> getAll() {
        return evaluationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDto> getById(@PathVariable Long id) {
        return evaluationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EvaluationDto> create(@RequestBody EvaluationDto dto) {
        return ResponseEntity.ok(evaluationService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        evaluationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
