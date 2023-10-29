package com.education.projects.birds.manager.service;
import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.exception.BirdNotFoundException;
import com.education.projects.birds.manager.integration.mediaHolder.MediaHolderClient;
import com.education.projects.birds.manager.mapper.BirdMapper;
import com.education.projects.birds.manager.repository.BirdRepository;
import com.education.projects.birds.manager.repository.SearchCriteria;
import com.education.projects.birds.manager.repository.BirdCriteriaRepository;
import com.education.projects.birds.manager.repository.BirdSpecification;
import com.education.projects.birds.manager.entity.BirdPage;
import com.education.projects.birds.manager.entity.BirdSearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

/**
 * The class for service User information in database
 */
@Service
@Slf4j
public class DBBirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository birdRepository;
    @Autowired
    private SpeciesStatusServiceImpl speciesStatusServiceImpl;
    @Autowired
    private ConservationStatusServiceImpl conservationStatusServiceImpl;
    @Autowired
    private BirdCriteriaRepository birdCriteriaRepository;
    @Autowired
    private BirdMapper birdMapper;
//    Autowired
//    private MediaHolderClient mediaHolderClient;

    /**
     * Creates a new User object information in the database, returns a User object from database by id
     *
     * @param birdDtoReq User object to be added to the database
     * @return User object information from database by id
     * @throws Exception
     */
    public BirdDtoResp createBird(BirdDtoReq birdDtoReq) throws Exception {

            Bird bird = birdMapper.birdDtoToBird(birdDtoReq);
            bird.setConservationStatus(conservationStatusServiceImpl.getConservationStatusById(birdDtoReq.getId_conservation_status()));
            bird.setSpeciesStatus(speciesStatusServiceImpl.getSpeciesStatusById(birdDtoReq.getId_species_status()));

            BirdDtoResp birdDtoResp = birdMapper.birdToBirdDto(birdRepository.save(bird));
            birdDtoResp.setId_species_status(bird.getSpeciesStatus().getId());
            birdDtoResp.setId_conservation_status(bird.getConservationStatus().getId());
        //    birdDtoResp.setAvatar_id(mediaHolderClient.);
            return birdDtoResp;

    }

    /**
     * Updates the User object information by id with update user information
     *
     * @param birdDtoReq User object information to update
     * @param id  id of the user object to be updated
     * @return User object information from database by id
     * @throws Exception
     */
    public BirdDtoResp updateBird(BirdDtoReq birdDtoReq, UUID id) throws Exception {

            if (birdRepository.existsById(id)) {
                Bird birdToChange = birdMapper.birdDtoToBird(birdDtoReq);
                birdToChange.setConservationStatus(conservationStatusServiceImpl.getConservationStatusById(birdDtoReq.getId_conservation_status()));
                birdToChange.setSpeciesStatus(speciesStatusServiceImpl.getSpeciesStatusById(birdDtoReq.getId_species_status()));
                birdToChange.setId(id);
                BirdDtoResp birdDtoResp = birdMapper.birdToBirdDto(birdRepository.save(birdToChange));
                birdDtoResp.setId_species_status(birdToChange.getSpeciesStatus().getId());
                birdDtoResp.setId_conservation_status(birdToChange.getConservationStatus().getId());

                return birdDtoResp;
            }else throw new BirdNotFoundException(id);

    }

    /**
     * Gets all users objects information from database
     *
     * @return The list of the User objects
     */
    public Collection<BirdDtoResp> getAllBirds() {
            return birdMapper.birdListToBirdDtoList(birdRepository.findAll());
    }

    /**
     * Gets the User object information from the database by id
     *
     * @param id id of the user object in database
     * @return The User object from database
     * @throws Exception
     */
    public BirdDtoResp getBirdById(UUID id) throws BirdNotFoundException {
            if (birdRepository.existsById(id))
                return birdMapper.birdToBirdDto(birdRepository.getReferenceById(id));
            else throw new BirdNotFoundException(id);
    }

    /**
     * Removes the row with id from database
     *
     * @param id is a row in database
     */
    public void deleteBirdById(UUID id) throws BirdNotFoundException {

            if (birdRepository.existsById(id))
                birdRepository.deleteById(id);
            else throw new BirdNotFoundException(id);
    }

    @Override
    public Collection<Bird> getSortedFilteredBirds(BirdPage birdPage, BirdSearchCriteria birdSearchCriteria) throws Exception {
        return null;
    }


    public Page<BirdDtoResp> getSortedFilteredBirdsCommon(BirdPage birdPage,
                                                          BirdSearchCriteria birdSearchCriteria){

            return birdCriteriaRepository.findAllWithFilters(birdPage, birdSearchCriteria);

    }
}
