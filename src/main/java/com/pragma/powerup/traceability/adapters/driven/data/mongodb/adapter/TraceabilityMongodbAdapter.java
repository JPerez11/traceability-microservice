package com.pragma.powerup.traceability.adapters.driven.data.mongodb.adapter;

import com.pragma.powerup.traceability.adapters.driven.data.mongodb.mapper.TraceabilityEntityMapper;
import com.pragma.powerup.traceability.adapters.driven.data.mongodb.repository.TraceabilityRepository;
import com.pragma.powerup.traceability.domain.models.TraceabilityModel;
import com.pragma.powerup.traceability.domain.spi.TraceabilityPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TraceabilityMongodbAdapter implements TraceabilityPersistencePort {

    private final TraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Override
    public void saveHistory(TraceabilityModel traceabilityModel) {
        traceabilityRepository.save(traceabilityEntityMapper.toCollection(traceabilityModel));
    }

    @Override
    public List<TraceabilityModel> getHistory(Long customerId) {
        return traceabilityEntityMapper.toModelList(
                traceabilityRepository.findByCustomerId(customerId)
        );
    }
}
