package com.example.evaluation.service;

import com.example.evaluation.dto.EvaluationDto;
import com.example.evaluation.mapper.EvaluationMapper;
import com.example.evaluation.model.Evaluation;
import com.example.evaluation.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private EvaluationMapper evaluationMapper;

    public EvaluationDto save(EvaluationDto dto) {
        Evaluation evaluation = evaluationMapper.toEntity(dto);
        Evaluation saved = evaluationRepository.save(evaluation);
        return evaluationMapper.toDto(saved);
    }

    public List<EvaluationDto> findAll() {
        return evaluationRepository.findAll()
                .stream()
                .map(evaluationMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EvaluationDto> findById(Long id) {
        return evaluationRepository.findById(id)
                .map(evaluationMapper::toDto);
    }

    public void delete(Long id) {
        evaluationRepository.deleteById(id);
    }
}
