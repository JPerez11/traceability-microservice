package com.pragma.powerup.traceability.adapters.driven.data.mongodb.mapper;

import com.pragma.powerup.traceability.adapters.driven.data.mongodb.entity.TraceabilityEntity;
import com.pragma.powerup.traceability.domain.models.TraceabilityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TraceabilityEntityMapper {

    TraceabilityModel toModel(TraceabilityEntity traceabilityEntity);
    TraceabilityEntity toCollection(TraceabilityModel traceabilityModel);
    List<TraceabilityModel> toModelList(List<TraceabilityEntity> traceabilityEntityList);


}
