package com.example.evaluation.service;

import com.example.evaluation.dto.CompetenceMetierDTO;
import com.example.evaluation.mapper.CompetenceMetierMapper;
import com.example.evaluation.model.Appreciation;
import com.example.evaluation.model.AppreciationId;
import com.example.evaluation.model.CompetenceMetier;
import com.example.evaluation.repository.AppreciationRepository;
import com.example.evaluation.repository.CompetenceMetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceMetierService {

    private final CompetenceMetierRepository repository;
    private final CompetenceMetierMapper mapper;
    private final AppreciationRepository appreciationRepository;

    @Autowired
    public CompetenceMetierService(
            CompetenceMetierRepository repository,
            CompetenceMetierMapper mapper,
            AppreciationRepository appreciationRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.appreciationRepository = appreciationRepository;
    }

    public CompetenceMetierDTO save(CompetenceMetierDTO dto) {
        CompetenceMetier entity = mapper.toEntity(dto);

        AppreciationId appreciationId = new AppreciationId(
                dto.getAppreciationIdTuteur(),
                dto.getAppreciationIdPeriode()
        );

        Optional<Appreciation> appreciationOpt = appreciationRepository.findById(appreciationId);
        appreciationOpt.ifPresent(entity::setAppreciation);

        CompetenceMetier saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public List<CompetenceMetierDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }
}
