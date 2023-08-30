package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.SpeciesStatusDtoResp;
import com.education.projects.birds.manager.entity.SpeciesStatus;

import java.util.Collection;
import java.util.UUID;

public interface SpeciesStatusService {
    Collection<SpeciesStatusDtoResp> getAllSpeciesStatus() throws Exception;
    SpeciesStatusDtoResp getSpeciesStatusDtoById(UUID id) throws Exception;
    SpeciesStatus getSpeciesStatusById(UUID id) throws Exception;
}
