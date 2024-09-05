package org.example.traveltour.repository;

import org.example.traveltour.model.Destination;
import org.example.traveltour.model.Guide;
import org.example.traveltour.model.Tour;
import org.example.traveltour.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query("select t.destinations from Tour t WHERE  t.id=:tourId")
    List<Destination> findDestinationsByTourId(Long tourId);

    @Query("SELECT t.travelers FROM Tour t WHERE t.id = :tourId")
    List<Traveler> findTravelersByTourId(Long tourId);

    @Query("select t from Tour t JOIN  t.travelers  tr where tr.id= :travelerId")
    List<Tour> findToursByTravelerId(Long travelerId);

    @Query("SELECT g FROM Tour t JOIN t.guides g WHERE t.id = :tourId")
    List<Guide> findGuidesByTourId(Long tourId);

    @Query("SELECT g from Guide g  where  g.id not in (SELECT g.id FROM Tour t JOIN t.guides g WHERE t.startDate <= :endDate AND t.endDate >= :startDate)")
    List<Guide> findAvailableGuidesDuringPeriod(Date startDate, Date endDate);

}
