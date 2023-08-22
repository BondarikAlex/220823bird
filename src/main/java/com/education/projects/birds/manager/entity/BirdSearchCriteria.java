package com.education.projects.birds.manager.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirdSearchCriteria {

    @Schema (name = "russian_name", description = "Bird russian_name", example = "Гусяра")
    @NotBlank (message = "russian_name should not be blank")
    @Size(min = 1, max = 100, message = "32 characters max")
    private String russian_name;

    @Schema (name = "latin_name", description = "Bird latin_name", example = "Гусяра")
    @NotBlank (message = "latin_name should not be blank")
    @Size(min = 1, max = 100, message = "32 characters max")
    private String latin_name;

    @Schema (name = "english_title", description = "Bird english_title", example = "Гусяра")
    @NotBlank (message = "english_title should not be blank")
    @Size(min = 1, max = 100, message = "32 characters max")
    private String english_title;



    @Schema (name = "speciesStatusId", description = "Bird speciesStatus", example = "2")
    @NotNull (message = "speciesStatusId should not be empty")
    @Positive (message = "speciesStatusId should be positive")
    @Digits(integer = 2, fraction = 0, message = "integer number of not more than 2 characters")
    private Integer speciesStatusId;

    @Schema (name = "conservationStatusId", description = "Bird conservationStatus", example = "3")
    @NotNull (message = "conservationStatusId should not be empty")
    @Positive (message = "conservationStatusId should be positive")
    @Digits(integer = 2, fraction = 0, message = "integer number of not more than 2 characters")
    private Integer conservationStatusId;
}
