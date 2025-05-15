package com.example.evaluation.controller;

import com.example.evaluation.repository.StagiaireRepository;
import com.example.evaluation.repository.TuteurRepository;
import com.example.evaluation.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistiques")

public class StatistiqueController {

    @Autowired
    private StagiaireRepository stagiaireRepository;

    @Autowired
    private TuteurRepository tuteurRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    @GetMapping("/nombre-stagiaires")
    public long getNombreDeStagiaires() {
        return stagiaireRepository.count();
    }

    @GetMapping("/nombre-tuteurs")
    public long getNombreDeTuteurs() {
        return tuteurRepository.count();
    }

    @GetMapping("/nombre-evaluations")
    public long getNombreEvaluations() {
        return evaluationRepository.count();
    }
}
