package com.education.projects.birds.manager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ConservationStatusDtoResp {

    @Schema(name = "id", description = "ConservationStatus id", example = "1")
    private UUID id;

    @Schema (name = "status_name", description = "Description of the status_name", example = "administrator")
    private String status_name;
}
