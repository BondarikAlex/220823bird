package com.education.projects.birds.manager.controller;

import com.education.projects.birds.manager.dto.response.SpeciesStatusDtoResp;
import com.education.projects.birds.manager.service.SpeciesStatusServiceImpl;
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
@Tag(name = "SpeciesStatus API")
public class SpeciesStatusController {
    @Autowired
    private SpeciesStatusServiceImpl speciesStatusServiceImpl;

    @Operation(summary = "Gets information about all SpeciesStates from database",
            description = "Returns collection of level objects from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/species_status")
    public ResponseEntity<Collection<SpeciesStatusDtoResp>> getpeciesStatusServices() throws Exception {
        log.info("Get all speciesStatus info");
        return new ResponseEntity <> (speciesStatusServiceImpl.getAllSpeciesStatus(), HttpStatus.OK);
    }

    @Operation(summary = "Gets speciesStatus by id",
            description = "Returns id speciesStatus information from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found - The level was not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/species_status/{id}")
    public ResponseEntity<SpeciesStatusDtoResp> getSpeciesStatusById(@PathVariable("id") @NotNull @Min(1) Integer id)
            throws Exception{
        log.info("Gets speciesStatus with id = {}", id);
        return new ResponseEntity <> (speciesStatusServiceImpl.getSpeciesStatusDtoById(id), HttpStatus.OK);
    }
}
