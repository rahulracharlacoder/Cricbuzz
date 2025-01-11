package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.TeamConverter;
import com.example.Crizbuzz.dto.request.TeamRequest;
import com.example.Crizbuzz.dto.response.TeamResponse;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.model.Team;
import com.example.Crizbuzz.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    Logger loggers = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest) {
        loggers.info("addMatches method started");
        Team team = TeamConverter.TeamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        loggers.info("addMatches method started");
        return TeamConverter.TeamToTeamResponse(savedTeam);
    }

    public TeamResponse getTeam(int team_id) {
        loggers.info("getTeam method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in getTeam method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        loggers.info("getTeam method started");
        return TeamConverter.TeamToTeamResponse(team);
    }

    public List<TeamResponse> getAllTeams() {
        loggers.info("getAllTeams method started");
        List<Team> teams = teamRepository.findAll();
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team: teams) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team));
        }
        loggers.info("getAllTeams method started");
        return teamResponses;
    }

    public List<TeamResponse> getByName(String name) {
        loggers.info("getByName method started");
        List<Team> team = teamRepository.findByName(name);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByName method started");
        return teamResponses;
    }

    public List<TeamResponse> getByRanking(int ranking) {
        loggers.info("getByRanking method started");
        List<Team> team = teamRepository.findByRanking(ranking);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByRanking method started");
        return teamResponses;
    }

    public List<TeamResponse> getByIccPoints(int iccPoints) {
        loggers.info("getByIccPoints method started");
        List<Team> team = teamRepository.findByIccPoints(iccPoints);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByIccPoints method started");
        return teamResponses;
    }

    public List<TeamResponse> getByCoach(String coach) {
        loggers.info("getByCoach method started");
        List<Team> team = teamRepository.findByCoach(coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByCoach method started");
        return teamResponses;
    }

    public List<TeamResponse> getByNameAndRanking(String name, int ranking) {
        loggers.info("getByNameAndRanking method started");
        List<Team> team = teamRepository.findByNameAndRanking(name, ranking);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByNameAndRanking method started");
        return teamResponses;
    }

    public List<TeamResponse> getByNameAndIccPoints(String name, int iccPoints) {
        loggers.info("getByNameAndIccPoints method started");
        List<Team> team = teamRepository.findByNameAndIccPoints(name, iccPoints);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByNameAndIccPoints method started");
        return teamResponses;
    }

    public List<TeamResponse> getByNameAndCoach(String name, String coach) {
        loggers.info("getByNameAndCoach method started");
        List<Team> team = teamRepository.findByNameAndCoach(name, coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByNameAndCoach method started");
        return teamResponses;
    }

    public List<TeamResponse> getByRankingAndIccPoints(int ranking, int iccPoints) {
        loggers.info("getByRankingAndIccPoints method started");
        List<Team> team = teamRepository.findByRankingAndIccPoints(ranking, iccPoints);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByRankingAndIccPoints method started");
        return teamResponses;
    }

    public List<TeamResponse> getByRankingAndCoach(int ranking, String coach) {
        loggers.info("getByRankingAndCoach method started");
        List<Team> team = teamRepository.findByRankingAndCoach(ranking, coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByRankingAndCoach method started");
        return teamResponses;
    }

    public List<TeamResponse> getByIccPointsAndCoach(int iccPoints, String coach) {
        loggers.info("getByIccPointsAndCoach method started");
        List<Team> team = teamRepository.findByIccPointsAndCoach(iccPoints, coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByIccPointsAndCoach method started");
        return teamResponses;
    }

    public List<TeamResponse> getByNameRankingAndIccPoints(String name, int ranking, int iccPoints) {
        loggers.info("getByNameRankingAndIccPoints method started");
        List<Team> team = teamRepository.findByNameRankingAndIccPoints(name, ranking, iccPoints);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByNameRankingAndIccPoints method started");
        return teamResponses;
    }

    public List<TeamResponse> getByNameRankingAndCoach(String name, int ranking, String coach) {
        loggers.info("getByNameRankingAndCoach method started");
        List<Team> team = teamRepository.findByNameRankingAndCoach(name, ranking, coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByNameRankingAndCoach method started");
        return teamResponses;
    }

    public List<TeamResponse> getByRankingIccPointsAndCoach(int ranking, int iccPoints, String coach) {
        loggers.info("getByRankingIccPointsAndCoach method started");
        List<Team> team = teamRepository.findByRankingIccPointsAndCoach(ranking, iccPoints, coach);
        List<TeamResponse> teamResponses = new ArrayList<>();
        for(Team team1: team) {
            teamResponses.add(TeamConverter.TeamToTeamResponse(team1));
        }
        loggers.info("getByRankingIccPointsAndCoach method started");
        return teamResponses;
    }

    public String updateTeam(TeamRequest teamRequest, int team_id) {
        loggers.info("updateTeam method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in updateTeam method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        team.setName(teamRequest.getName());
        team.setRanking(teamRequest.getRanking());
        team.setIccPoints(teamRequest.getIccPoints());
        team.setCoach(teamRequest.getCoach());
        teamRepository.save(team);
        loggers.info("updateTeam method started");
        return "Team info updated successfully";
    }

    public String updateName(String name, int team_id) {
        loggers.info("updateName method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in updateName method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        team.setName(name);
        teamRepository.save(team);
        loggers.info("updateName method started");
        return "Name updated successfully";
    }

    public String updateRanking(int ranking, int team_id) {
        loggers.info("updateRanking method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in updateRanking method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        team.setRanking(ranking);
        teamRepository.save(team);
        loggers.info("updateRanking method started");
        return "Ranking updated successfully";
    }

    public String updateIccPoints(int iccPoints, int team_id) {
        loggers.info("updateIccPoints method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in updateIccPoints method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        team.setIccPoints(iccPoints);
        teamRepository.save(team);
        loggers.info("updateIccPoints method started");
        return "IccPoints updated successfully";
    }

    public String updateCoach(String coach, int team_id) {
        loggers.info("updateCoach method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in updateCoach method");
            throw new TeamNotFoundException("Invalid team id");
        }
        Team team = optionalTeam.get();
        team.setCoach(coach);
        teamRepository.save(team);
        loggers.info("updateCoach method started");
        return "Coach updated successfully";
    }

    public String deleteTeam(int team_id) {
        loggers.info("deleteTeam method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(optionalTeam.isEmpty()) {
            loggers.error("Exception occurred in deleteTeam method");
            throw new TeamNotFoundException("Invalid team id");
        }
        teamRepository.delete(optionalTeam.get());
        loggers.info("deleteTeam method started");
        return "Team info deleted successfully";
    }
}
