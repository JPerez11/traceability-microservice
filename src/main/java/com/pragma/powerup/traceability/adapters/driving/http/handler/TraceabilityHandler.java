package com.pragma.powerup.traceability.adapters.driving.http.handler;

import com.pragma.powerup.traceability.adapters.driving.http.dto.TraceabilityDto;

import java.util.List;

public interface TraceabilityHandler {

    void saveHistory(TraceabilityDto traceabilityDto);
    List<TraceabilityDto> getHistory(Long customerId);

}
