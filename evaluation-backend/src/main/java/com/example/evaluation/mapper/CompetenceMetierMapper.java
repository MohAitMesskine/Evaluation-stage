package com.example.evaluation.mapper;

import com.example.evaluation.dto.CompetenceMetierDTO;
import com.example.evaluation.model.CompetenceMetier;
import com.example.evaluation.model.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMetierMapper {

    @Mapping(source = "appreciation.id.idTuteur", target = "appreciationIdTuteur")
    @Mapping(source = "appreciation.id.idPeriode", target = "appreciationIdPeriode")
    CompetenceMetierDTO toDto(CompetenceMetier entity);

    @Mapping(target = "appreciation", ignore = true) // à gérer manuellement dans le service
    CompetenceMetier toEntity(CompetenceMetierDTO dto);

    List<CompetenceMetierDTO> toDtoList(List<CompetenceMetier> entities);

    default Niveau mapStringToNiveau(String value) {
        if (value == null) return null;
        try {
            return Niveau.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
