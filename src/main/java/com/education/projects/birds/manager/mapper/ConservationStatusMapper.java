package com.education.projects.birds.manager.mapper;

import com.education.projects.birds.manager.dto.response.ConservationStatusDtoResp;
import com.education.projects.birds.manager.entity.ConservationStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConservationStatusMapper {
    ConservationStatusDtoResp conservationStatusToConservationStatusDto(ConservationStatus conservationStatus);
    List<ConservationStatusDtoResp> conservationStatusListToConservationStatusDtoList(List<ConservationStatus> conservationStatuses);
}
