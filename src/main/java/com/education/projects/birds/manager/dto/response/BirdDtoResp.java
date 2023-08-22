package com.education.projects.birds.manager.dto.response;

import com.education.projects.birds.manager.entity.ConservationStatus;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class BirdDtoResp {

    @Schema(name = "id", description = "Bird id", example = "1")
    private Integer Id;

    @Schema (name = "avatar_id", description = "Bird avatar_id", example = "John")
    private String avatar_id;

    @Schema (name = "description", description = "Bird description", example = "Описание птицы говоруна")
    private String description;

    @Schema (name = "russian_name", description = "Bird russian_name", example = "Птица Говорун")
    private String russian_name;

    @Schema (name = "latin_name", description = "Bird latin_name", example = "Птица Говорун")
    private String latin_name;

    @Schema (name = "english_title", description = "Bird english_title", example = "Птица Говорун")
    private String english_title;

    @Schema (name = "id_species_status", description = "Bird speciesStatus", example = "2")
    private Integer id_species_status;

    @Schema (name = "id_conservation_status", description = "Bird id_conservation_status", example = "3")
    private Integer id_conservation_status;

    @Schema (name = "createdAt", description = "Bird creation date", example = "2017-05-14T10:34")
    private LocalDateTime createdAt;

    @Schema (name = "modificationAt", description = "Bird modification date", example = "2017-05-14T10:34")
    private LocalDateTime modificationAt;
}




