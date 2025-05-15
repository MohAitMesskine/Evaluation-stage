
package com.example.evaluation.mapper;

        import com.example.evaluation.dto.AppreciationDto;
        import com.example.evaluation.model.Appreciation;
        import org.mapstruct.Mapper;
        import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppreciationMapper {
    AppreciationMapper INSTANCE = Mappers.getMapper(AppreciationMapper.class);

    Appreciation toEntity(AppreciationDto dto);
    AppreciationDto toDto(Appreciation entity);
}
