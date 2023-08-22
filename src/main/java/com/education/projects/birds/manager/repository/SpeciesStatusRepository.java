package com.education.projects.birds.manager.repository;

import com.education.projects.birds.manager.entity.ConservationStatus;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesStatusRepository extends JpaRepository <SpeciesStatus, Integer> {
}
