package com.example.evaluation.mapper;


import com.example.evaluation.dto.CategorieDto;
import com.example.evaluation.model.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategorieMapper {

    CategorieDto toDto(Categorie categorie);
    Categorie toEntity(CategorieDto dto);
}
