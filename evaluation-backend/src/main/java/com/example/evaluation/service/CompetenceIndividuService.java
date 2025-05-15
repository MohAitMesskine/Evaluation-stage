package com.example.evaluation.service;

import com.example.evaluation.dto.CompetenceIndividuDTO;
import com.example.evaluation.mapper.CompetenceIndividuMapper;
import com.example.evaluation.model.Appreciation;
import com.example.evaluation.model.AppreciationId;
import com.example.evaluation.model.CompetenceIndividu;
import com.example.evaluation.repository.AppreciationRepository;
import com.example.evaluation.repository.CompetenceIndividuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenceIndividuService {

    private final CompetenceIndividuRepository competenceIndividuRepository;
    private final AppreciationRepository appreciationRepository;
    private final CompetenceIndividuMapper mapper;

    public CompetenceIndividuService(CompetenceIndividuRepository competenceIndividuRepository,
                                     AppreciationRepository appreciationRepository,
                                     CompetenceIndividuMapper mapper) {
        this.competenceIndividuRepository = competenceIndividuRepository;
        this.appreciationRepository = appreciationRepository;
        this.mapper = mapper;
    }

    public CompetenceIndividuDTO save(CompetenceIndividuDTO dto) {
        // Ajoute un log ici pour voir ce qui est reçu
        System.out.println("DTO reçu: " + dto);

        CompetenceIndividu entity = mapper.toEntity(dto);

        // Log avant la sauvegarde
        System.out.println("Entité avant sauvegarde: " + entity);

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

        CompetenceIndividu saved = competenceIndividuRepository.save(entity);

        // Log après sauvegarde
        System.out.println("Entité après sauvegarde: " + saved);

        return mapper.toDto(saved);
    }



    public List<CompetenceIndividuDTO> findAll() {
        return competenceIndividuRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CompetenceIndividuDTO findById(Long id) {
        CompetenceIndividu entity = competenceIndividuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence Individu non trouvée !"));
        return mapper.toDto(entity);
    }

    public void deleteById(Long id) {
        competenceIndividuRepository.deleteById(id);
    }
}
