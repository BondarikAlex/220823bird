package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.request.UserDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.dto.response.UserDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.SpeciesStatus;

import java.util.Collection;

/**
 * The interface for service User objects information
 */
public interface BirdService {

    BirdDtoResp createBird(BirdDtoReq birdDtoReq) throws Exception;

    BirdDtoResp updateBird(BirdDtoReq birdDtoReq, Integer id) throws Exception;

    Collection<BirdDtoResp> getAllBirds() throws Exception;

    BirdDtoResp getBirdById(Integer id) throws Exception;

    void deleteBirdById(Integer id) throws Exception;

    Collection<Bird> getSortedFilteredBirds(String sortBy, String sortDirection, String filter)
            throws Exception;
}
