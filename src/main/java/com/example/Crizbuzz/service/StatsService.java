package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.StatsConverter;
import com.example.Crizbuzz.dto.request.StatsRequest;
import com.example.Crizbuzz.dto.response.StatsResponse;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.model.Player;
import com.example.Crizbuzz.model.Stats;
import com.example.Crizbuzz.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StatsService {

    Logger loggers = LoggerFactory.getLogger(StatsService.class);

    @Autowired
    PlayerRepository playerRepository;

    public StatsResponse getStats(StatsRequest statsRequest, int playerId) {
        loggers.info("getStats method started");
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()) {
            loggers.error("Exception occurred in getStats method");
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = optionalPlayer.get();

        Stats stats = StatsConverter.statsRequestToStats(statsRequest);

        player.setStats(stats);

        stats.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);

        loggers.info("getStats method started");
        return StatsConverter.statsToStatsResponse(savedPlayer.getStats());
    }

    public StatsResponse getById(int player_id) {
        loggers.info("getById method started");
        Optional<Player> optionalPlayer = playerRepository.findById(player_id);
        if(optionalPlayer.isEmpty()) {
            loggers.error("Exception occurred in getById method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Stats stats = optionalPlayer.get().getStats();
        loggers.info("getById method started");
        return StatsConverter.statsToStatsResponse(stats);
    }

    public String updateStats(StatsRequest statsRequest, int player_id) {
        loggers.info("updateStats method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateStats method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        Stats stats = player1.getStats();
        stats.setRuns(statsRequest.getRuns());
        stats.setWickets(statsRequest.getWickets());
        stats.setBattingAverage(statsRequest.getBattingAverage());
        stats.setBowlingAverage(statsRequest.getBattingAverage());
        player1.setStats(stats);
        playerRepository.save(player1);
        loggers.info("updateStats method started");
        return "Stats of player of id "+player_id+" updated successfully";
    }

    public String updateRuns(int runs, int player_id) {
        loggers.info("updateRuns method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateRuns method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        Stats stats = player1.getStats();
        stats.setRuns(runs);
        playerRepository.save(player1);
        loggers.info("updateRuns method started");
        return "Runs of player "+player_id+" updated successfully";
    }

    public String updateWickets(int wickets, int player_id) {
        loggers.info("updateWickets method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateWickets method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        Stats stats = player1.getStats();
        stats.setWickets(wickets);
        playerRepository.save(player1);
        loggers.info("updateWickets method started");
        return "Wickets of player "+player_id+" updated successfully";
    }

    public String updateBattingAverage(double battingAverage, int player_id) {
        loggers.info("updateBattingAverage method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateBattingAverage method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        Stats stats = player1.getStats();
        stats.setBattingAverage(battingAverage);
        playerRepository.save(player1);
        loggers.info("updateBattingAverage method started");
        return "Batting average of player "+player_id+" updated successfully";
    }

    public String updateBowlingAverage(double bowlingAverage, int player_id) {
        loggers.info("updateBowlingAverage method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateBowlingAverage method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        Stats stats = player1.getStats();
        stats.setBowlingAverage(bowlingAverage);
        playerRepository.save(player1);
        loggers.info("updateBowlingAverage method started");
        return "Bowling average of player "+player_id+" updated successfully";
    }

    public String deleteStats(int player_id) {
        loggers.info("deleteStats method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in deleteStats method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setStats(null);
        playerRepository.save(player1);
        loggers.info("deleteStats method started");
        return "Stats of player of id "+player_id+" deleted successfully";
    }
}
