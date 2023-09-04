package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.ConservationStatusDtoResp;
import com.education.projects.birds.manager.entity.ConservationStatus;

import java.util.Collection;


public interface ConservationStatusService {

    Collection<ConservationStatusDtoResp> getAllConservationStatus() throws Exception;
    ConservationStatusDtoResp getConservationStatusDtoById(Integer id) throws Exception;
    ConservationStatus getConservationStatusById(Integer id) throws Exception;
}
