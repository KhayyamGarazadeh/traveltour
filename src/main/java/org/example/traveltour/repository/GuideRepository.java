package org.example.traveltour.repository;

import org.example.traveltour.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Query("SELECT g FROM Guide g WHERE g.id NOT IN (SELECT g.id FROM Guide g JOIN g.tours t WHERE t.startDate <= :endDate AND t.endDate >= :startDate)")
    List<Guide> findAvailableGuides(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
