package com.education.projects.birds.manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "species_status")
public class SpeciesStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "SpeciesStatus id", example = "1")
    @Column(name = "id", insertable = false)
    private Integer id;

    @Schema (name = "status_name", description = "Description of the status_name", example = "Гнездящие")
    @Column(name = "status_name", nullable = false)
    private String status_name;
}