package org.example.traveltour.repository;

import org.example.traveltour.model.Destination;
import org.example.traveltour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Tour> findByTour_id(Long tour_id);
}
