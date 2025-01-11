package com.example.Crizbuzz.repository;

import com.example.Crizbuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByName(String name);

    List<Team> findByRanking(int ranking);

    List<Team> findByIccPoints(int iccPoints);

    List<Team> findByCoach(String coach);

    List<Team> findByNameAndRanking(String name, int ranking);

    List<Team> findByNameAndIccPoints(String name, int iccPoints);

    List<Team> findByNameAndCoach(String name, String coach);

    List<Team> findByRankingAndIccPoints(int ranking, int iccPoints);

    List<Team> findByRankingAndCoach(int ranking, String coach);

    List<Team> findByIccPointsAndCoach(int iccPoints, String coach);

    @Query(value = "SELECT * from team WHERE name =:name AND ranking =:ranking AND icc_points =:iccPoints", nativeQuery = true)
    List<Team> findByNameRankingAndIccPoints(String name, int ranking, int iccPoints);

    @Query(value = "SELECT * from team WHERE name =:name AND ranking =:ranking AND coach =:coach", nativeQuery = true)
    List<Team> findByNameRankingAndCoach(String name, int ranking, String coach);

    @Query(value = "SELECT * from team WHERE ranking =:ranking AND icc_points =:iccPoints AND coach =:coach", nativeQuery = true)
    List<Team> findByRankingIccPointsAndCoach(int ranking, int iccPoints, String coach);
}
