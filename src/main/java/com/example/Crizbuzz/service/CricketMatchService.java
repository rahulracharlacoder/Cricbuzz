package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.CricketMatchConverter;
import com.example.Crizbuzz.dto.request.CricketMatchRequest;
import com.example.Crizbuzz.dto.response.CricketMatchResponse;
import com.example.Crizbuzz.exception.CricketMatchNotFoundException;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.model.CricketMatch;
import com.example.Crizbuzz.model.Team;
import com.example.Crizbuzz.repository.CricketMatchRepository;
import com.example.Crizbuzz.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CricketMatchService {

    Logger loggers = LoggerFactory.getLogger(CricketMatchService.class);

    @Autowired
    CricketMatchRepository cricketMatchRepository;

    @Autowired
    TeamRepository teamRepository;

    public CricketMatchResponse addMatches(CricketMatchRequest cricketMatchRequest, int teamAId, int teamBId) {
        loggers.info("addMatches method started");
        Optional<Team> optionalTeamA =  teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB =  teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()) {
            if(optionalTeamA.isEmpty()) {
                loggers.error("Exception occurred in addMatches method for Team A");
                throw new TeamNotFoundException("Team of "+teamAId+" is not present");
            }
            else {
                loggers.error("Exception occurred in addMatches method for Team B");
                throw new TeamNotFoundException("Team of " + teamBId + " is not present");
            }
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch cricketMatch = CricketMatchConverter.CricketMatchRequestToCricketMatch(cricketMatchRequest);
        cricketMatch.getTeams().add(teamA);
        cricketMatch.getTeams().add(teamB);

        teamA.setMatchesPlayed(teamA.getMatchesPlayed()+1);
        teamA.getCricketMatches().add(cricketMatch);

        teamB.setMatchesPlayed(teamA.getMatchesPlayed()+1);
        teamB.getCricketMatches().add(cricketMatch);

        CricketMatch savedCricketMatch = cricketMatchRepository.save(cricketMatch);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        loggers.info("addMatches method ended");
        return CricketMatchConverter.CricketToCricketMatchResponse(savedCricketMatch);
    }

    public List<CricketMatchResponse> getAllMatches() {
        loggers.info("getAllMatches method started");
        List<CricketMatch> cricketMatches = cricketMatchRepository.findAll();
        List<CricketMatchResponse> cricketMatchResponses = new ArrayList<>();
        for(CricketMatch cricketMatch:cricketMatches) {
            cricketMatchResponses.add(CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch));
        }
        loggers.info("getAllMatches method ended");
        return cricketMatchResponses;
    }

    public CricketMatchResponse getById(int cricketMatch_id) {
        loggers.info("getById method started");
        Optional<CricketMatch> cricketMatch = cricketMatchRepository.findById(cricketMatch_id);
        if(cricketMatch.isEmpty()) {
            loggers.error("Exception occurred in getById method");
            throw new CricketMatchNotFoundException("Invalid match id");
        }
        loggers.info("getById method ended");
        return CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch.get());
    }

    public List<CricketMatchResponse> getByTitle(String title) {
        loggers.info("getByTitle method started");
        List<CricketMatch> cricketMatches = cricketMatchRepository.findByTitle(title);
        List<CricketMatchResponse> cricketMatchResponses = new ArrayList<>();
        for(CricketMatch cricketMatch:cricketMatches) {
            cricketMatchResponses.add(CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch));
        }
        loggers.info("getByTitle method ended");
        return cricketMatchResponses;
    }

    public List<CricketMatchResponse> getByVenue(String venue) {
        loggers.info("getByVenue method started");
        List<CricketMatch> cricketMatches = cricketMatchRepository.findByVenue(venue);
        List<CricketMatchResponse> cricketMatchResponses = new ArrayList<>();
        for(CricketMatch cricketMatch:cricketMatches) {
            cricketMatchResponses.add(CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch));
        }
        loggers.info("getByVenue method ended");
        return cricketMatchResponses;
    }

    public List<CricketMatchResponse> getByDate(Date matchDate) {
        loggers.info("getByDate method started");
        List<CricketMatch> cricketMatches = cricketMatchRepository.findByDate(matchDate);
        List<CricketMatchResponse> cricketMatchResponses = new ArrayList<>();
        for(CricketMatch cricketMatch:cricketMatches) {
            cricketMatchResponses.add(CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch));
        }
        loggers.info("getByDate method ended");
        return cricketMatchResponses;
    }

    public List<CricketMatchResponse> getStartToEndDateRange(Date startDate, Date endDate) {
        loggers.info("getStartToEndDateRange method started");
        List<CricketMatch> cricketMatches = cricketMatchRepository.findByStartToEndDateRange(startDate, endDate);
        List<CricketMatchResponse> cricketMatchResponses = new ArrayList<>();
        for(CricketMatch cricketMatch:cricketMatches) {
            cricketMatchResponses.add(CricketMatchConverter.CricketToCricketMatchResponse(cricketMatch));
        }
        loggers.info("getStartToEndDateRange method ended");
        return cricketMatchResponses;
    }

    public String updateMatch(int match_id, CricketMatchRequest cricketMatchRequest) {
        loggers.info("updateMatch method started");
        Optional<CricketMatch> cricketMatch = cricketMatchRepository.findById(match_id);
        if(cricketMatch.isEmpty()) {
            loggers.error("Exception occurred in updateMatch method");
            throw new CricketMatchNotFoundException("Invalid match id");
        }
        CricketMatch cricketMatch1 = cricketMatch.get();
        cricketMatch1.setTitle(cricketMatchRequest.getTitle());
        cricketMatch1.setVenue(cricketMatchRequest.getVenue());
        cricketMatchRepository.save(cricketMatch1);
        loggers.info("updateMatch method ended");
        return "Match info updated successfully";
    }

    public String updateTitle(int match_id, String title) {
        loggers.info("updateTitle method started");
        Optional<CricketMatch> cricketMatch = cricketMatchRepository.findById(match_id);
        if(cricketMatch.isEmpty()) {
            loggers.error("Exception occurred in updateTitle method");
            throw new CricketMatchNotFoundException("Invalid match id");
        }
        CricketMatch cricketMatch1 = cricketMatch.get();
        cricketMatch1.setTitle(title);
        cricketMatchRepository.save(cricketMatch1);
        loggers.info("updateTitle method ended");
        return "Title updated successfully";
    }

    public String updateVenue(int match_id, String venue) {
        loggers.info("updateVenue method started");
        Optional<CricketMatch> cricketMatch = cricketMatchRepository.findById(match_id);
        if(cricketMatch.isEmpty()) {
            loggers.error("Exception occurred in updateVenue method");
            throw new CricketMatchNotFoundException("Invalid match id");
        }
        CricketMatch cricketMatch1 = cricketMatch.get();
        cricketMatch1.setVenue(venue);
        cricketMatchRepository.save(cricketMatch1);
        loggers.info("updateVenue method ended");
        return "Title updated successfully";
    }

    public String deleteMatch(int match_id) {
        loggers.info("deleteMatch method started");
        Optional<CricketMatch> cricketMatch = cricketMatchRepository.findById(match_id);
        if(cricketMatch.isEmpty()) {
            loggers.error("Exception occurred in deleteMatch method");
            throw new CricketMatchNotFoundException("Invalid match id");
        }
        cricketMatchRepository.deleteById(match_id);
        loggers.info("deleteMatch method ended");
        return "Match info deleted successfully";
    }
}
