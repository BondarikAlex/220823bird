package com.education.projects.birds.manager.repository;

import com.education.projects.birds.manager.entity.ConservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConservationStatusRepository extends JpaRepository <ConservationStatus, Integer> {

}
