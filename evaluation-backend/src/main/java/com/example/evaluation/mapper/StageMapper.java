
package com.example.evaluation.mapper;

import com.example.evaluation.dto.StageDto;
import com.example.evaluation.model.Stage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { StagiaireMapper.class, PeriodeMapper.class })
public interface StageMapper {

    Stage toEntity(StageDto dto);

    StageDto toDto(Stage stage);
}

