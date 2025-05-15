package com.example.evaluation.service;

import com.example.evaluation.model.CompetenceEntreprise;
import com.example.evaluation.repository.CompetenceEntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.evaluation.dto.CompetenceEntrepriseDTO;
import com.example.evaluation.mapper.CompetenceEntrepriseMapper;
import com.example.evaluation.model.Appreciation;
import com.example.evaluation.model.AppreciationId;
import com.example.evaluation.model.CompetenceEntreprise;
import com.example.evaluation.repository.AppreciationRepository;
import com.example.evaluation.repository.CompetenceEntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceEntrepriseService {

    private final CompetenceEntrepriseRepository competenceEntrepriseRepository;
    private final AppreciationRepository appreciationRepository;
    private final CompetenceEntrepriseMapper mapper;

    public CompetenceEntrepriseService(CompetenceEntrepriseRepository competenceEntrepriseRepository,
                                       AppreciationRepository appreciationRepository,
                                       CompetenceEntrepriseMapper mapper) {
        this.competenceEntrepriseRepository = competenceEntrepriseRepository;
        this.appreciationRepository = appreciationRepository;
        this.mapper = mapper;
    }

    public CompetenceEntrepriseDTO save(CompetenceEntrepriseDTO dto) {
        System.out.println("DTO reçu: " + dto);

        CompetenceEntreprise entity = mapper.toEntity(dto);

        if (dto.getAppreciationIdTuteur() == null || dto.getAppreciationIdPeriode() == null) {
            throw new RuntimeException("Les deux ID (tuteur et période) doivent être présents !");
        }

        AppreciationId appreciationId = new AppreciationId(
                dto.getAppreciationIdTuteur(),
                dto.getAppreciationIdPeriode()
        );

        Appreciation appreciation = appreciationRepository.findById(appreciationId)
                .orElseThrow(() -> new RuntimeException("Appreciation non trouvée avec ces IDs !"));

        entity.setAppreciation(appreciation);

        CompetenceEntreprise saved = competenceEntrepriseRepository.save(entity);

        System.out.println("Entité sauvegardée: " + saved);

        return mapper.toDto(saved);
    }

    public List<CompetenceEntrepriseDTO> findAll() {
        return competenceEntrepriseRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CompetenceEntrepriseDTO findById(Long id) {
        CompetenceEntreprise entity = competenceEntrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence Entreprise non trouvée !"));
        return mapper.toDto(entity);
    }

    public void deleteById(Long id) {
        competenceEntrepriseRepository.deleteById(id);
    }
}

