package com.pragma.powerup.traceability.adapters.driven.data.mongodb.repository;

import com.pragma.powerup.traceability.adapters.driven.data.mongodb.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceabilityRepository extends MongoRepository<TraceabilityEntity, String> {

    List<TraceabilityEntity> findByCustomerId(Long customerId);

}
