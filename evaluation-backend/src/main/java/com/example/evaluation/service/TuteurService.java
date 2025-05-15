package com.example.evaluation.service;

import com.example.evaluation.mapper.TuteurMapper;
import com.example.evaluation.dto.TuteurDto;
import com.example.evaluation.model.Tuteur;
import com.example.evaluation.repository.TuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TuteurService {
    @Autowired
    private TuteurRepository tuteurRepository;

    @Autowired
    private TuteurMapper tuteurMapper;

    public List<TuteurDto> findAll() {
        return tuteurRepository.findAll()
                .stream()
                .map(tuteurMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<TuteurDto> findById(Long id) {
        return tuteurRepository.findById(id)
                .map(tuteurMapper::toDto);
    }

    public TuteurDto save(TuteurDto dto) {
        Tuteur tuteur = tuteurMapper.toEntity(dto);
        return tuteurMapper.toDto(tuteurRepository.save(tuteur));
    }

    public void delete(Long id) {
        tuteurRepository.deleteById(id);
    }
}

