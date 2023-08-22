package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.SpeciesStatusDtoResp;
import com.education.projects.birds.manager.entity.SpeciesStatus;

import java.util.Collection;

public interface SpeciesStatusService {
    Collection<SpeciesStatusDtoResp> getAllSpeciesStatus() throws Exception;
    SpeciesStatusDtoResp getSpeciesStatusDtoById(Integer id) throws Exception;
    SpeciesStatus getSpeciesStatusById(Integer id) throws Exception;
}
