package com.education.projects.birds.manager.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "conservation_status")
public class ConservationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "ConservationStatus id", example = "1")
    @Column(name = "id", insertable = false)
    private Integer id;

    @Schema (name = "status_name", description = "Description of the status_name", example = "Изчезающие")
    @Column(name = "status_name", nullable = false)
    private String status_name;
}
