package com.example.evaluation.mapper;


import com.example.evaluation.dto.EvaluationDto;
import com.example.evaluation.model.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PeriodeMapper.class})
public interface EvaluationMapper {
    EvaluationDto toDto(Evaluation evaluation);
    Evaluation toEntity(EvaluationDto dto);
}
