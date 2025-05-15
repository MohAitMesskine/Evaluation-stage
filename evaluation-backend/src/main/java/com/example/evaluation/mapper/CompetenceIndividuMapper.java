package com.example.evaluation.mapper;

import com.example.evaluation.dto.CompetenceIndividuDTO;
import com.example.evaluation.model.CompetenceIndividu;
import com.example.evaluation.model.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenceIndividuMapper {

    @Mapping(source = "appreciation.id.idTuteur", target = "appreciationIdTuteur")
    @Mapping(source = "appreciation.id.idPeriode", target = "appreciationIdPeriode")
    CompetenceIndividuDTO toDto(CompetenceIndividu entity);

    @Mapping(target = "appreciation", ignore = true)
    CompetenceIndividu toEntity(CompetenceIndividuDTO dto);

    default Niveau mapStringToNiveau(String value) {
        if (value == null) {
            return null;
        }
        return Niveau.valueOf(value);  // Convertion de la chaîne en énumération
    }
}
