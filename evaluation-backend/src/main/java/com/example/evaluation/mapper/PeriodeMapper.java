package com.example.evaluation.mapper;

import com.example.evaluation.dto.PeriodeDto;
import com.example.evaluation.dto.PeriodeIdDto;
import com.example.evaluation.model.Periode;
import com.example.evaluation.model.PeriodeId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodeMapper {
    PeriodeDto toDto(Periode p);
    Periode toEntity(PeriodeDto dto);
    PeriodeIdDto toDto(PeriodeId id);
    PeriodeId toEntity(PeriodeIdDto dto);
}
