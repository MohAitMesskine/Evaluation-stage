package com.example.evaluation.mapper;

import com.example.evaluation.dto.CompetenceEntrepriseDTO;
import com.example.evaluation.model.CompetenceEntreprise;
import com.example.evaluation.model.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenceEntrepriseMapper {

    @Mapping(source = "appreciation.id.idTuteur", target = "appreciationIdTuteur")
    @Mapping(source = "appreciation.id.idPeriode", target = "appreciationIdPeriode")
    CompetenceEntrepriseDTO toDto(CompetenceEntreprise entity);

    @Mapping(target = "appreciation", ignore = true)
    CompetenceEntreprise toEntity(CompetenceEntrepriseDTO dto);

    default Niveau mapStringToNiveau(String value) {
        if (value == null) {
            return null;
        }
        return Niveau.valueOf(value); // conversion string -> enum
    }
}
