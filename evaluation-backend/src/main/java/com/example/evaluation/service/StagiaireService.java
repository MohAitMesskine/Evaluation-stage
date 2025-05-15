package com.example.evaluation.service;

import com.example.evaluation.mapper.StagiaireMapper;
import com.example.evaluation.dto.StagiaireDto;
import com.example.evaluation.model.Stagiaire;
import com.example.evaluation.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class StagiaireService {
    @Autowired
    private StagiaireRepository stagiaireRepository;

    @Autowired
    private StagiaireMapper stagiaireMapper;

    public List<StagiaireDto> findAll() {
        try {
            return stagiaireRepository.findAll()
                    .stream()
                    .map(stagiaireMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching stagiaires", e);
        }
    }

    public Optional<StagiaireDto> findById(Long id) {
        try {
            return stagiaireRepository.findById(id)
                    .map(stagiaireMapper::toDto);
        } catch (Exception e) {
            throw new RuntimeException("Error finding stagiaire by ID", e);
        }
    }

    public StagiaireDto save(StagiaireDto dto) {
        try {
            Stagiaire stagiaire = stagiaireMapper.toEntity(dto);
            return stagiaireMapper.toDto(stagiaireRepository.save(stagiaire));
        } catch (Exception e) {
            throw new RuntimeException("Error saving stagiaire", e);
        }
    }

    public void delete(Long id) {
        try {
            stagiaireRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting stagiaire", e);
        }
    }
}
