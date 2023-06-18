package com.pragma.powerup.traceability.domain.usecase;

import com.pragma.powerup.traceability.domain.api.TraceabilityServicePort;
import com.pragma.powerup.traceability.domain.models.TraceabilityModel;
import com.pragma.powerup.traceability.domain.spi.TraceabilityPersistencePort;

import java.util.List;

public class TraceabilityUseCase implements TraceabilityServicePort {

    private final TraceabilityPersistencePort traceabilityPersistencePort;

    public TraceabilityUseCase(TraceabilityPersistencePort traceabilityPersistencePort) {
        this.traceabilityPersistencePort = traceabilityPersistencePort;
    }

    @Override
    public void saveHistory(TraceabilityModel traceabilityModel) {
        traceabilityPersistencePort.saveHistory(traceabilityModel);
    }

    @Override
    public List<TraceabilityModel> getHistory(Long customerId) {
        return traceabilityPersistencePort.getHistory(customerId);
    }
}
