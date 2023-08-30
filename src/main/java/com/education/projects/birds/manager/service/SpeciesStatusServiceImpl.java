package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.SpeciesStatusDtoResp;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import com.education.projects.birds.manager.mapper.SpeciesStatusMapper;
import com.education.projects.birds.manager.repository.SpeciesStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@Slf4j
public class SpeciesStatusServiceImpl  {
    @Autowired
    private SpeciesStatusRepository speciesStatusRepository;
    @Autowired
    private SpeciesStatusMapper speciesStatusMapper;

    /**
     * Gets all SpeciesStatus objects information from database
     *
     * @return The list of the SpeciesStatus objects
     */
    public Collection<SpeciesStatusDtoResp> getAllSpeciesStatus() throws Exception{
        try {
            return speciesStatusMapper.speciesStatusListToSpeciesStatusDtoList(speciesStatusRepository.findAll());
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Gets the SpeciesStatus object information from the database by id
     *
     * @param id id of the SpeciesStatus object in database
     * @return The SpeciesStatus object from database
     * @throws Exception
     */
    public SpeciesStatusDtoResp getSpeciesStatusDtoById(UUID id) throws Exception {
        try {
            if (speciesStatusRepository.existsById(id))
                return speciesStatusMapper.speciesStatusToSpeciesStatusDto(speciesStatusRepository.getReferenceById(id));
            else {
                Exception e = new Exception("The SpeciesStatus wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public SpeciesStatus getSpeciesStatusById(UUID id) throws Exception {
        try {
            if (speciesStatusRepository.existsById(id))
                return speciesStatusRepository.getReferenceById(id);
            else {
                Exception e = new Exception("The SpeciesStatus wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
