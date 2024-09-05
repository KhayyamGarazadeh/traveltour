package org.example.traveltour.repository;

import org.example.traveltour.model.Traveler;
import org.example.traveltour.service.specfication.TravelerSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {
   // Object findAll(TravelerSpecification travelerSpecification, PageRequest id);
}
