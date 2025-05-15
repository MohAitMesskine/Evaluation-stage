package com.example.evaluation.mapper;


import com.example.evaluation.dto.CompetenceDto;
import com.example.evaluation.model.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {

    CompetenceDto toDto(Competence competence);
    Competence toEntity(CompetenceDto dto);
}
