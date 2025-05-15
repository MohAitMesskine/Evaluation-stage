package com.example.evaluation.service;

import com.example.evaluation.dto.CompetenceDto;
import com.example.evaluation.mapper.CompetenceMapper;
import com.example.evaluation.model.Competence;
import com.example.evaluation.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private CompetenceMapper competenceMapper;

    public List<CompetenceDto> findAll() {
        return competenceRepository.findAll().stream()
                .map(competenceMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CompetenceDto> findById(Long id) {
        return competenceRepository.findById(id).map(competenceMapper::toDto);
    }

    public CompetenceDto save(CompetenceDto dto) {
        Competence competence = competenceMapper.toEntity(dto);
        return competenceMapper.toDto(competenceRepository.save(competence));
    }

    public void delete(Long id) {
        competenceRepository.deleteById(id);
    }
}
