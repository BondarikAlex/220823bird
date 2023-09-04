package com.education.projects.birds.manager.dto.request;

import com.education.projects.birds.manager.entity.ConservationStatus;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class BirdDtoReq {


    @Schema (name = "english_title", description = "Bird english_title", example = "John")
    @NotBlank (message = "english_title should not be blank")
    @Size(min = 1, max = 150, message = "150 characters max")
    private String english_title;

    @Schema (name = "lastName", description = "Bird latin_name", example = "Smith")
    @NotBlank (message = "LastName should not be blank")
    @Size(min = 1, max = 150, message = "150 characters max")
    private String latin_name;

    @Schema (name = "russian_name", description = "Bird russian_name", example = "Gib5!?jEs#")
    @NotBlank (message = "russian_name should not be blank")
    @Size(min = 1, max = 150, message = "150 characters max")
    private String russian_name;

    @Schema (name = "avatar_id", description = "Bird avatar_id", example = "abcdefg@gmail.com")
    @NotBlank (message = "avatar_id should not be blank")
    @Size(min = 1, max = 32, message = "32 characters max")
    private String avatar_id;

    @Schema (name = "description", description = "Bird description", example = "+375334455667")
    @NotBlank (message = "description should not be blank")
    @Size(min = 7, max = 1000, message = "1000 characters max")
    private String description;

    @Schema (name = "id_conservation_status", description = "Bird id_conservation_status", example = "2")
    @NotNull (message = "id_conservation_status should not be empty")
    @Positive (message = "id_conservation_status should be positive")
    @Digits(integer = 2, fraction = 0, message = "integer number of not more than 2 characters")
    private Integer id_conservation_status;

    @Schema (name = "id_species_status", description = "Bird id_species_status", example = "3")
    @NotNull (message = "id_species_status should not be empty")
    @Positive (message = "id_species_status should be positive")
    @Digits(integer = 2, fraction = 0, message = "integer number of not more than 2 characters")
    private Integer id_species_status;
}
