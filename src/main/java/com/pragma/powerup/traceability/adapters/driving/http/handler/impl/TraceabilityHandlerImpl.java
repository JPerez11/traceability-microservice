package com.pragma.powerup.traceability.adapters.driving.http.handler.impl;

import com.pragma.powerup.traceability.adapters.driving.http.dto.TraceabilityDto;
import com.pragma.powerup.traceability.adapters.driving.http.handler.TraceabilityHandler;
import com.pragma.powerup.traceability.adapters.driving.http.mapper.TraceabilityDtoMapper;
import com.pragma.powerup.traceability.domain.api.TraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceabilityHandlerImpl implements TraceabilityHandler {

    private final TraceabilityServicePort traceabilityServicePort;
    private final TraceabilityDtoMapper traceabilityDtoMapper;

    @Override
    public void saveHistory(TraceabilityDto traceabilityDto) {
        traceabilityServicePort.saveHistory(traceabilityDtoMapper.toModel(traceabilityDto));
    }

    @Override
    public List<TraceabilityDto> getHistory(Long customerId) {
        return traceabilityDtoMapper.toDtoList(traceabilityServicePort.getHistory(customerId));
    }
}
