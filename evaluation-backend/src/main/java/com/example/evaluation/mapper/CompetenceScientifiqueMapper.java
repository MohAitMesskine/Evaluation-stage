package com.example.evaluation.mapper;

import com.example.evaluation.dto.CompetenceScientifiqueDTO;
import com.example.evaluation.model.CompetenceScientifique;
import com.example.evaluation.model.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceScientifiqueMapper {

    // Mappage pour la conversion de l'entité en DTO
    @Mapping(source = "appreciation.id.idTuteur", target = "appreciationIdTuteur")
    @Mapping(source = "appreciation.id.idPeriode", target = "appreciationIdPeriode")
    CompetenceScientifiqueDTO toDto(CompetenceScientifique entity);

    // Mappage pour la conversion du DTO en entité
    @Mapping(target = "appreciation", ignore = true)
    CompetenceScientifique toEntity(CompetenceScientifiqueDTO dto);

    // Conversion d'une liste d'entités en une liste de DTO
    List<CompetenceScientifiqueDTO> toDtoList(List<CompetenceScientifique> entities);

    // Mapper String -> Niveau
    default Niveau mapStringToNiveau(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Niveau.valueOf(value);  // Conversion de la chaîne en énumération
        } catch (IllegalArgumentException e) {
            return null;  // Ou retourner un niveau par défaut si nécessaire
        }
    }
}
