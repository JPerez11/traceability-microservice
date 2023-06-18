package com.pragma.powerup.traceability.adapters.driving.http.mapper;

import com.pragma.powerup.traceability.adapters.driving.http.dto.TraceabilityDto;
import com.pragma.powerup.traceability.domain.models.TraceabilityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TraceabilityDtoMapper {

    TraceabilityModel toModel(TraceabilityDto traceabilityDto);
    TraceabilityDto toDto(TraceabilityModel traceabilityModel);
    List<TraceabilityDto> toDtoList(List<TraceabilityModel> traceabilityModelList);

}
