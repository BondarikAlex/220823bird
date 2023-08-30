package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.ConservationStatusDtoResp;
import com.education.projects.birds.manager.entity.ConservationStatus;

import java.util.Collection;
import java.util.UUID;

public interface ConservationStatusService {

    Collection<ConservationStatusDtoResp> getAllConservationStatus() throws Exception;
    ConservationStatusDtoResp getConservationStatusDtoById(UUID id) throws Exception;
    ConservationStatus getConservationStatusById(UUID id) throws Exception;
}
