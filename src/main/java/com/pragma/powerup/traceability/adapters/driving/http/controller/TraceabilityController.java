package com.pragma.powerup.traceability.adapters.driving.http.controller;

import com.pragma.powerup.traceability.adapters.driving.http.dto.TraceabilityDto;
import com.pragma.powerup.traceability.adapters.driving.http.handler.TraceabilityHandler;
import com.pragma.powerup.traceability.configuration.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/traceability")
public class TraceabilityController {

    private final TraceabilityHandler traceabilityHandler;

    @Operation(summary = "Save history",
            responses = {
                    @ApiResponse(responseCode = "201", description = "history saved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "Not found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Conflict",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> saveHistory(@Valid @RequestBody TraceabilityDto traceabilityDto) {
        traceabilityHandler.saveHistory(traceabilityDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(
                        Constants.RESPONSE_MESSAGE_KEY,
                        Constants.HISTORY_SAVED_MESSAGE));
    }

    @Operation(summary = "Get history",
            responses = {
                    @ApiResponse(responseCode = "201", description = "history returned successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "Not found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Conflict",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/{id}")
    public ResponseEntity<List<TraceabilityDto>> getHistory(@PathVariable Long id) {
        return ResponseEntity.ok(traceabilityHandler.getHistory(id));
    }

}
