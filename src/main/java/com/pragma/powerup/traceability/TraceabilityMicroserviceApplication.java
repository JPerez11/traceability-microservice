package com.pragma.powerup.traceability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TraceabilityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceabilityMicroserviceApplication.class, args);
	}

}
