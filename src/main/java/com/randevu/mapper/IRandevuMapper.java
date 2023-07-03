package com.randevu.mapper;

import com.randevu.dto.request.RandevuCreateRequestDTO;
import com.randevu.dto.response.RandevuResponseDTO;
import com.randevu.repository.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRandevuMapper {
    IRandevuMapper INSTANCE = Mappers.getMapper(IRandevuMapper.class);

    @Mapping(target = "id", ignore = true) // ID alanını yoksay
    Randevu toSave(RandevuCreateRequestDTO dto);

    RandevuResponseDTO toDto(Randevu randevu);
}
