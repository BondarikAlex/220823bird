package com.education.projects.birds.manager.repository;
import com.education.projects.birds.manager.entity.Bird;
import com.education.projects.birds.manager.entity.SpeciesStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BirdSpecification implements Specification<Bird> {
    private SearchCriteria criteria;

    public BirdSpecification(SearchCriteria searchCriteria) {
    }

    @Override
    public Predicate toPredicate(Root<Bird> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase("eq")) {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        } else return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
    }
}
