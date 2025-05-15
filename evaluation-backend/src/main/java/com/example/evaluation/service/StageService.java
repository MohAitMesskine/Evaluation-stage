package com.example.evaluation.service;

import com.example.evaluation.dto.StageDto;
import com.example.evaluation.mapper.StageMapper;
import com.example.evaluation.model.Stage;
import com.example.evaluation.repository.StageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
@Service
public class StageService {
    private final StageRepository stageRepository;
    private final StageMapper stageMapper;

    public StageService(StageRepository stageRepository, StageMapper stageMapper) {
        this.stageRepository = stageRepository;
        this.stageMapper = stageMapper;
    }
    @Transactional
    public StageDto save(StageDto dto) {
        try {
            Stage entity = stageMapper.toEntity(dto);
            return stageMapper.toDto(stageRepository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Error saving stage", e);
        }
    }
}
