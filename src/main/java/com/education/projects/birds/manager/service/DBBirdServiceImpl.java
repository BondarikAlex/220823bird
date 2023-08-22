package com.education.projects.birds.manager.service;
import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
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

    /**
     * Creates a new User object information in the database, returns a User object from database by id
     *
     * @param birdDtoReq User object to be added to the database
     * @return User object information from database by id
     * @throws Exception
     */
    public BirdDtoResp createBird(BirdDtoReq birdDtoReq) throws Exception {
        try {
            Bird bird = birdMapper.birdDtoToBird(birdDtoReq);
            bird.setConservationStatus(conservationStatusServiceImpl.getConservationStatusById(birdDtoReq.getId_conservation_status()));
            bird.setSpeciesStatus(speciesStatusServiceImpl.getSpeciesStatusById(birdDtoReq.getId_conservation_status()));

            BirdDtoResp birdDtoResp = birdMapper.birdToBirdDto(
                    birdRepository.save(bird));
            birdDtoResp.setId_species_status(bird.getConservationStatus().getId());
            birdDtoResp.setId_species_status(bird.getConservationStatus().getId());
            return birdDtoResp;
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Updates the User object information by id with update user information
     *
     * @param birdDtoReq User object information to update
     * @param id  id of the user object to be updated
     * @return User object information from database by id
     * @throws Exception
     */
    public BirdDtoResp updateBird(BirdDtoReq birdDtoReq, Integer id) throws Exception {
        try {
            if (birdRepository.existsById(id)) {
                Bird birdToChange = birdMapper.birdDtoToBird(birdDtoReq);
                birdToChange.setId(id);
                return birdMapper.birdToBirdDto(birdRepository.save(birdToChange));
            } else {
                Exception e = new Exception("The bird wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception ex){
            log.error("Error: {}", ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * Gets all users objects information from database
     *
     * @return The list of the User objects
     */
    public Collection<BirdDtoResp> getAllBirds() throws Exception{
        try {
            return birdMapper.birdListToBirdDtoList(birdRepository.findAll());
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Gets the User object information from the database by id
     *
     * @param id id of the user object in database
     * @return The User object from database
     * @throws Exception
     */
    public BirdDtoResp getBirdById(Integer id) throws Exception {
        try {
            if (birdRepository.existsById(id))
                return birdMapper.birdToBirdDto(birdRepository.getReferenceById(id));
            else {
                Exception e = new Exception("The bird wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Removes the row with id from database
     *
     * @param id is a row in database
     */
    public void deleteBirdById(Integer id) throws Exception {
        try {
            if (birdRepository.existsById(id))
                birdRepository.deleteById(id);
            else {
                Exception e = new Exception("The bird wasn't found");
                log.error("Error: {}", e.getMessage());
                throw e;
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Sorts and filters Users objects information from database, returns list of User objects
     *
     * @param sortBy        Sets the sort order
     * @param sortDirection Sets the sort direction (ACK/DESC)
     * @param filter        The filter parameter, which need to parse
     * @return The list of the User objects
     * @throws Exception
     */
    public Collection<Bird> getSortedFilteredBirds(String sortBy, String sortDirection, String filter)
            throws Exception {

        String[] arrFilter = filter.split("\\.");
        String key = arrFilter[1];
        String value = arrFilter[2];
        String operation = (arrFilter[0].equals("eq")) ? "= " : "!= ";

        BirdSpecification spec = new BirdSpecification(new SearchCriteria(key, operation, value));
        return birdRepository.findAll(spec);
    }

    public Page<BirdDtoResp> getSortedFilteredBirdsCommon(BirdPage birdPage,
                                                          BirdSearchCriteria birdSearchCriteria)
    throws Exception{
        try {
            return birdCriteriaRepository.findAllWithFilters(birdPage, birdSearchCriteria);
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
