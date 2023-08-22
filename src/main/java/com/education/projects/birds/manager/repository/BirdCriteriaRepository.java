package com.education.projects.birds.manager.repository;

import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.BirdPage;
import com.education.projects.birds.manager.entity.BirdSearchCriteria;
import com.education.projects.birds.manager.mapper.BirdMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BirdCriteriaRepository {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    @Autowired
    BirdMapper birdMapper;

    public BirdCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<BirdDtoResp> findAllWithFilters(BirdPage birdPage,
                                                BirdSearchCriteria birdSearchCriteria){
        CriteriaQuery<Bird> criteriaQuery = criteriaBuilder.createQuery(Bird.class);
        Root<Bird> birdRoot = criteriaQuery.from(Bird.class);
        Predicate predicate = getPredicate(birdSearchCriteria, birdRoot);
        criteriaQuery.where(predicate);

        setOrder(birdPage, criteriaQuery, birdRoot);

        TypedQuery<Bird> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(birdPage.getPageNumber() * birdPage.getPageSize());
        typedQuery.setMaxResults(birdPage.getPageSize());

        Pageable pageable = getPageable(birdPage);

        long birdsCount = 10;

        return (new PageImpl<>(
                birdMapper.birdListToBirdDtoList(typedQuery.getResultList()),
                pageable,
                birdsCount));
    }

    private long getBirdsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Bird> countRoot = countQuery.from(Bird.class);
        countQuery.select(criteriaBuilder.count(countRoot));
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(BirdPage birdPage) {
        Sort sort = Sort.by(birdPage.getSortDirection(), birdPage.getSortBy());
        return PageRequest.of(birdPage.getPageNumber(), birdPage.getPageSize(), sort);
    }

    private void setOrder(BirdPage birdPage,
                          CriteriaQuery<Bird> criteriaQuery,
                          Root<Bird> birdRoot) {
        if(birdPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(birdRoot.get(birdPage.getSortBy())));
        } else criteriaQuery.orderBy(criteriaBuilder.desc(birdRoot.get(birdPage.getSortBy())));
    }

    private Predicate getPredicate(BirdSearchCriteria birdSearchCriteria,
                                   Root<Bird> birdRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(birdSearchCriteria.getLatin_name()))
            predicates.add(criteriaBuilder.like(birdRoot.get("latin_name"),
                    "%" + birdSearchCriteria.getLatin_name() + "%"));
        if(Objects.nonNull(birdSearchCriteria.getEnglish_title()))
            predicates.add(criteriaBuilder.like(birdRoot.get("english_title"),
                    "%" + birdSearchCriteria.getEnglish_title() + "%"));
        if(Objects.nonNull(birdSearchCriteria.getRussian_name()))
            predicates.add(criteriaBuilder.like(birdRoot.get("russian_name"),
                    "%" + birdSearchCriteria.getRussian_name() + "%"));
        if(Objects.nonNull(birdSearchCriteria.getConservationStatusId()))
            predicates.add(criteriaBuilder.equal(birdRoot.get("id_conservation_status"),
                    birdSearchCriteria.getConservationStatusId()));
        if(Objects.nonNull(birdSearchCriteria.getSpeciesStatusId()))
            predicates.add(criteriaBuilder.equal(birdRoot.get("id_species_status"),
                    birdSearchCriteria.getSpeciesStatusId()));
        return criteriaBuilder.and(predicates.toArray((new Predicate[0])));
    }
}
