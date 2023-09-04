package com.education.projects.birds.manager.controller;

import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.BirdPage;
import com.education.projects.birds.manager.entity.BirdSearchCriteria;
import com.education.projects.birds.manager.service.DBBirdServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@Validated
@Slf4j
@Tag(name = "Birds API")
public class BirdController {

    @Autowired
    private DBBirdServiceImpl dbBirdServiceImpl;

    @Operation(summary = "Creates new row in database with bird information",
            description = "Returns created bird information from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @PostMapping("/birds")  //url
    public ResponseEntity<BirdDtoResp> createBird (@Valid @RequestBody BirdDtoReq birdDtoReq)
            throws Exception{
        log.info("Create bird = {}", birdDtoReq);
        return new ResponseEntity<> (dbBirdServiceImpl.createBird(birdDtoReq), HttpStatus.CREATED);
    }

    @Operation(summary = "Updates bird information by id",
            description = "Returns updated bird information from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The bird was not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @PutMapping("/birds/{id}")
    public ResponseEntity <BirdDtoResp> updateBird (
            @Valid @RequestBody BirdDtoReq birdDtoReq, @PathVariable ("id") @NotNull @Min(1) UUID id)
    throws Exception{
        log.info("Update bird with id = {}, update bird info {}", id, birdDtoReq);
        return new ResponseEntity<>(dbBirdServiceImpl.updateBird(birdDtoReq, id), HttpStatus.OK);
    }

    @Operation(summary = "Gets information about all birds from database",
            description = "Returns collection of bird objects from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/birds")
    public ResponseEntity <Collection<BirdDtoResp>> getBirds() throws Exception {
        log.info("Get all birds info");
        return new ResponseEntity <> (dbBirdServiceImpl.getAllBirds(), HttpStatus.OK);
    }

    @Operation(summary = "Gets sorted and filtered information about birds from database",
            description = "Returns collection of bird objects from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/sortedFilteredBirds")
    public ResponseEntity<Page<BirdDtoResp>> getSortFilterBirdsWithPagination(BirdPage birdPage,BirdSearchCriteria birdSearchCriteria)
         throws Exception{
            log.info("Get sorted and filtered bird info");
            return  new ResponseEntity<>(dbBirdServiceImpl.getSortedFilteredBirdsCommon(birdPage,birdSearchCriteria),HttpStatus.OK);
    }





    @Operation(summary = "Gets bird by id",
            description = "Returns id bird information from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found - The bird was not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @GetMapping("/birds/{id}")
    public ResponseEntity<BirdDtoResp> getBirdById(@PathVariable ("id") @NotNull  UUID id)
    throws Exception{
        log.info("Gets bird with id = {}", id);
        return new ResponseEntity <> (dbBirdServiceImpl.getBirdById(id), HttpStatus.OK);
    }

    @Operation(summary = "Deletes bird by id",
            description = "Removes the row with id from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found - The bird was not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @DeleteMapping("/birds/{id}")
    public ResponseEntity<String> deleteBirdById(@PathVariable ("id") @NotNull @Min(1) UUID id)
            throws Exception {
        log.info("Deletes bird with id = {}", id);
        dbBirdServiceImpl.deleteBirdById(id);
        return new ResponseEntity<>("The bird deleted", HttpStatus.OK);
    }
}
