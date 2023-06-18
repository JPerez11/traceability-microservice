package com.pragma.powerup.traceability.adapters.driving.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TraceabilityDto {

    private Long orderId;
    private Long customerId;
    private String customerEmail;
    private String previousStatus;
    private String newStatus;
    private Long employeeId;
    private String employeeEmail;

}
