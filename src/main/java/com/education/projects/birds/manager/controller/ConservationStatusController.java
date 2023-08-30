package com.education.projects.birds.manager.controller;

import com.education.projects.birds.manager.dto.response.ConservationStatusDtoResp;
import com.education.projects.birds.manager.service.ConservationStatusServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@Validated
@Slf4j
@Tag(name = "ConservationStatus API")
public class ConservationStatusController {
    @Autowired
    private ConservationStatusServiceImpl conservationStatusServiceImpl;

    @Operation(summary = "Gets information about all conservationStates from database",
            description = "Returns collection of conservationStatus objects from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/conservation_status")
    public ResponseEntity<Collection<ConservationStatusDtoResp>> getConservationStates() throws Exception {
        log.info("Get all conservationStates info");
        return new ResponseEntity <> (conservationStatusServiceImpl.getAllConservationStatus(), HttpStatus.OK);
    }

    @Operation(summary = "Gets conservationStatus by id",
            description = "Returns id conservationStatus information from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found - The role was not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/conservation_status/{id}")
    public ResponseEntity<ConservationStatusDtoResp> getConservationStatusById(@PathVariable("id") @NotNull @Min(1) UUID id)
            throws Exception{
        log.info("Gets conservationStatus with id = {}", id);
        return new ResponseEntity <> (conservationStatusServiceImpl.getConservationStatusDtoById(id), HttpStatus.OK);
    }
}
