package com.example.Crizbuzz.repository;

import com.example.Crizbuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CricketMatchRepository extends JpaRepository<CricketMatch, Integer> {
    List<CricketMatch> findByTitle(String title);

    List<CricketMatch> findByVenue(String venue);

    @Query(value = "SELECT * FROM cricket_match WHERE match_date = :matchDate", nativeQuery = true)
    List<CricketMatch> findByDate(Date matchDate);

    @Query(value = "SELECT * FROM cricket_match WHERE match_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<CricketMatch> findByStartToEndDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
