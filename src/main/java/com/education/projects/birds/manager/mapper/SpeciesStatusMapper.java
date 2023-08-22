package com.education.projects.birds.manager.mapper;

import com.education.projects.birds.manager.dto.response.SpeciesStatusDtoResp;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeciesStatusMapper {

    SpeciesStatusDtoResp speciesStatusToSpeciesStatusDto(SpeciesStatus speciesStatus);
    List<SpeciesStatusDtoResp> speciesStatusListToSpeciesStatusDtoList(List<SpeciesStatus> speciesStates);
}
