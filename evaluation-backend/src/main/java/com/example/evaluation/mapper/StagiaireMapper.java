package com.example.evaluation.mapper;

import com.example.evaluation.dto.StagiaireDto;
import com.example.evaluation.model.Stagiaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StagiaireMapper {
    StagiaireDto toDto(Stagiaire stagiaire);
    Stagiaire toEntity(StagiaireDto dto);
}
