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
public class SpeciesStatusServiceImpl implements SpeciesStatusService  {
    @Autowired
    private SpeciesStatusRepository speciesStatusRepository;
    @Autowired
    private SpeciesStatusMapper speciesStatusMapper;

    public Collection<SpeciesStatusDtoResp> getAllSpeciesStatus() throws Exception {
        Collection<SpeciesStatusDtoResp> result;
        try {
            result = speciesStatusMapper.speciesStatusListToSpeciesStatusDtoList(speciesStatusRepository.findAll());
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
        return result;
    }


     // Gets the SpeciesStatus object information from the database by id

    public SpeciesStatusDtoResp getSpeciesStatusDtoById(Integer id) throws Exception {
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

    public SpeciesStatus getSpeciesStatusById(Integer id) throws Exception {
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
