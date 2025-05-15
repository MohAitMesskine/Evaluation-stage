package com.example.evaluation.mapper;



import com.example.evaluation.dto.TuteurDto;
import com.example.evaluation.model.Tuteur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TuteurMapper {

    TuteurDto toDto(Tuteur tuteur);
    Tuteur toEntity(TuteurDto dto);
}
