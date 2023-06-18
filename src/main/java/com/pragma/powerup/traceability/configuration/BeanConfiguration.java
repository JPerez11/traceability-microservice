package com.pragma.powerup.traceability.configuration;

import com.pragma.powerup.traceability.adapters.driven.data.mongodb.adapter.TraceabilityMongodbAdapter;
import com.pragma.powerup.traceability.adapters.driven.data.mongodb.mapper.TraceabilityEntityMapper;
import com.pragma.powerup.traceability.adapters.driven.data.mongodb.repository.TraceabilityRepository;
import com.pragma.powerup.traceability.domain.api.TraceabilityServicePort;
import com.pragma.powerup.traceability.domain.spi.TraceabilityPersistencePort;
import com.pragma.powerup.traceability.domain.usecase.TraceabilityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Bean
    public TraceabilityPersistencePort traceabilityPersistencePort() {
        return new TraceabilityMongodbAdapter(traceabilityRepository, traceabilityEntityMapper);
    }

    @Bean
    public TraceabilityServicePort traceabilityServicePort() {
        return new TraceabilityUseCase(traceabilityPersistencePort());
    }

}
