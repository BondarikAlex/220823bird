
package com.education.projects.birds.manager.service;

import com.education.projects.birds.manager.dto.response.ConservationStatusDtoResp;
import com.education.projects.birds.manager.entity.ConservationStatus;
import com.education.projects.birds.manager.repository.ConservationStatusRepository;
import com.education.projects.birds.manager.mapper.ConservationStatusMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@Slf4j
public class ConservationStatusServiceImpl implements ConservationStatusService{
    @Autowired
    private ConservationStatusRepository conservationStatusRepository;
    @Autowired
    private  ConservationStatusMapper conservationStatusMapper ;


    public Collection<ConservationStatusDtoResp> getAllConservationStatus() throws Exception{
        try {
            return conservationStatusMapper.conservationStatusListToConservationStatusDtoList(conservationStatusRepository.findAll());
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }


    public ConservationStatusDtoResp getConservationStatusDtoById(Integer id) throws Exception {
        try {
            if (conservationStatusRepository.existsById(id))
                return conservationStatusMapper.conservationStatusToConservationStatusDto(conservationStatusRepository.getReferenceById(id));
            else {
                Exception e = new Exception("The ConservationStatus wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public ConservationStatus getConservationStatusById(Integer id) throws Exception {
        try {
            if (conservationStatusRepository.existsById(id))
                return conservationStatusRepository.getReferenceById(id);
            else {
                Exception e = new Exception("The ConservationStatus wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
