package org.example.traveltour.service.specfication;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.example.traveltour.criteria.TravelerCriteria;
import org.example.traveltour.model.Traveler;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.example.traveltour.constants.CriteriaConstants.AGE;
import static org.example.traveltour.constants.CriteriaConstants.BIRTH_PLACE;
import static org.example.traveltour.util.PredicateUtil.applyLikePattern;


@AllArgsConstructor
public class TravelerSpecification implements Specification<Traveler> {

    private TravelerCriteria travelerCriteria;

    @Override
    public Predicate toPredicate(Root<Traveler> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (travelerCriteria.getBirthPlace() != null) {
            predicates.add(criteriaBuilder.like(root.get(BIRTH_PLACE), applyLikePattern(travelerCriteria.getBirthPlace())));
        }

        if (travelerCriteria.getAgeFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(AGE), travelerCriteria.getAgeFrom()));
        }

        if (travelerCriteria.getAgeTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(AGE), travelerCriteria.getAgeTo()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    }




