package com.pragma.powerup.traceability.domain.spi;

import com.pragma.powerup.traceability.domain.models.TraceabilityModel;

import java.util.List;

public interface TraceabilityPersistencePort {

    void saveHistory(TraceabilityModel traceabilityModel);
    List<TraceabilityModel> getHistory(Long customerId);

}
