package com.example.evaluation.service;

import com.example.evaluation.dto.CategorieDto;
import com.example.evaluation.mapper.CategorieMapper;
import com.example.evaluation.model.Categorie;
import com.example.evaluation.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private CategorieMapper categorieMapper;

    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(categorieMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CategorieDto> findById(Long id) {
        return categorieRepository.findById(id).map(categorieMapper::toDto);
    }

    public CategorieDto save(CategorieDto dto) {
        Categorie categorie = categorieMapper.toEntity(dto);
        return categorieMapper.toDto(categorieRepository.save(categorie));
    }

    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }
}
