package com.education.projects.birds.manager.service;
import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.BirdPage;
import com.education.projects.birds.manager.entity.BirdSearchCriteria;

import java.util.Collection;
import java.util.UUID;

/**
 * The interface for service User objects information
 */
public interface BirdService {

    BirdDtoResp createBird(BirdDtoReq birdDtoReq) throws Exception;

    BirdDtoResp updateBird(BirdDtoReq birdDtoReq, UUID id) throws Exception;

    Collection<BirdDtoResp> getAllBirds() throws Exception;

    BirdDtoResp getBirdById(UUID id) throws Exception;

    void deleteBirdById(UUID id) throws Exception;

    Collection<Bird> getSortedFilteredBirds(BirdPage birdPage, BirdSearchCriteria birdSearchCriteria)
            throws Exception;
}
