package com.education.projects.birds.manager.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Table(name = "birds")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bird {

    public Bird() {
        if (createdAt == null)
            this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        else
            this.modificationAt = Timestamp.valueOf(LocalDateTime.now());

    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(name = "id", description = "Bird id", example = "1")
    @Column(name = "id", insertable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @Schema(name = "id_conservation_status", description = "Birds ConservationStatus", example = "2")
    @JoinColumn(name = "id_conservation_status", referencedColumnName = "id")
    private ConservationStatus conservationStatus;

    @OneToOne
    @Schema(name = "id_species_status", description = "Birds ConservationStatus", example = "3")
    @JoinColumn(name = "id_species_status", referencedColumnName = "id")
    private SpeciesStatus speciesStatus;

    @Schema (name = "createdAt", description = "User creation date", example = "2014-04-28T16:25:49.341")
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Schema (name = "modificationAt", description = "User modification date", example = "2014-04-28T16:25:49.341")
    @Column(name = "modification_at", nullable = true)
    private Timestamp modificationAt;

    @Schema (name = "english_title", description = "Bird english_title", example = "John")
    @Column(name = "english_title", nullable = false)
    private String english_title;

    @Schema (name = "latin_name", description = "Bird latin_name", example = "John")
    @Column(name = "latin_name", nullable = false)
    private String latin_name;

    @Schema (name = "russian_name", description = "Bird russian_name", example = "John")
    @Column(name = "russian_name", nullable = false)
    private String russian_name;

    @Schema (name = "description", description = "Bird description", example = "John")
    @Column(name = "description", nullable = false)
    private String description;

    @Schema (name = "description", description = "Bird description", example = "John")
    @Column(name = "avatar_id", nullable = false)
    private String avatar_id;


}


