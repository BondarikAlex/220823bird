package com.education.projects.birds.manager.repository;

import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer>, JpaSpecificationExecutor<Bird> {
   /* @Query("select")
    Collection <User> findAllByBrand();*/
}
