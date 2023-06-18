package com.pragma.powerup.traceability.adapters.driven.data.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "traceability")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraceabilityEntity {

    @Id
    private String id;
    @Field
    private Long orderId;
    @Field
    private Long customerId;
    @Field
    private String customerEmail;
    @Field
    private String previousStatus;
    @Field
    private String newStatus;
    @Field
    private Long employeeId;
    @Field
    private String employeeEmail;

}
