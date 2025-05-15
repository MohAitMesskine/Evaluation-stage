package com.example.evaluation.service;

import com.example.evaluation.dto.CompetenceScientifiqueDTO;
import com.example.evaluation.mapper.CompetenceScientifiqueMapper;
import com.example.evaluation.model.Appreciation;
import com.example.evaluation.model.AppreciationId;
import com.example.evaluation.model.CompetenceScientifique;
import com.example.evaluation.repository.AppreciationRepository;
import com.example.evaluation.repository.CompetenceScientifiqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenceScientifiqueService {

    private final CompetenceScientifiqueRepository competenceScientifiqueRepository;
    private final AppreciationRepository appreciationRepository;
    private final CompetenceScientifiqueMapper mapper;

    public CompetenceScientifiqueService(CompetenceScientifiqueRepository competenceScientifiqueRepository,
                                         AppreciationRepository appreciationRepository,
                                         CompetenceScientifiqueMapper mapper) {
        this.competenceScientifiqueRepository = competenceScientifiqueRepository;
        this.appreciationRepository = appreciationRepository;
        this.mapper = mapper;
    }

    public CompetenceScientifiqueDTO save(CompetenceScientifiqueDTO dto) {
        // Log pour vérifier les données reçues
        System.out.println("DTO reçu: " + dto);

        CompetenceScientifique entity = mapper.toEntity(dto);

        // Log avant la sauvegarde
        System.out.println("Entité avant sauvegarde: " + entity);

        // Vérification des ID Tuteur et Période
        if (dto.getAppreciationIdTuteur() == null || dto.getAppreciationIdPeriode() == null) {
            throw new RuntimeException("Les deux ID (Tuteur et Période) doivent être présents !");
        }

        // Création de l'ID composite pour l'Appreciation
        AppreciationId appreciationId = new AppreciationId(
                dto.getAppreciationIdTuteur(),
                dto.getAppreciationIdPeriode()
        );

        // Recherche de l'Appreciation avec l'ID composite
        Appreciation appreciation = appreciationRepository.findById(appreciationId)
                .orElseThrow(() -> new RuntimeException("Appreciation non trouvée avec ces IDs !"));

        // Association de l'Appreciation à l'entité CompetenceScientifique
        entity.setAppreciation(appreciation);

        // Sauvegarde de l'entité
        CompetenceScientifique saved = competenceScientifiqueRepository.save(entity);

        // Log après la sauvegarde
        System.out.println("Entité après sauvegarde: " + saved);

        // Retourner le DTO de l'entité sauvegardée
        return mapper.toDto(saved);
    }

    public List<CompetenceScientifiqueDTO> findAll() {
        return competenceScientifiqueRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CompetenceScientifiqueDTO findById(Long id) {
        CompetenceScientifique entity = competenceScientifiqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence Scientifique non trouvée !"));
        return mapper.toDto(entity);
    }

    public void deleteById(Long id) {
        competenceScientifiqueRepository.deleteById(id);
    }
}
