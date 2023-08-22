package com.education.projects.birds.manager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SpeciesStatusDtoResp {
    @Schema(name = "id", description = "status_name id", example = "1")
    private Integer id;

    @Schema (name = "status_name", description = "Description of the status_name", example = "administrator")
    private String status_name;
}
