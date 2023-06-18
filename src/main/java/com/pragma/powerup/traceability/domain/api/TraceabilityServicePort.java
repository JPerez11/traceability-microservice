package com.pragma.powerup.traceability.domain.api;

import com.pragma.powerup.traceability.domain.models.TraceabilityModel;

import java.util.List;

public interface TraceabilityServicePort {

    void saveHistory(TraceabilityModel traceabilityModel);
    List<TraceabilityModel> getHistory(Long customerId);

}
