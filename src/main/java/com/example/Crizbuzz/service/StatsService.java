package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.StatsConverter;
import com.example.Crizbuzz.dto.request.StatsRequest;
import com.example.Crizbuzz.dto.response.StatsResponse;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.model.Player;
import com.example.Crizbuzz.model.Stats;
import com.example.Crizbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    @Autowired
    PlayerRepository playerRepository;

    public StatsResponse getStats(StatsRequest statsRequest, int playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = optionalPlayer.get();

        Stats stats = StatsConverter.statsRequestToStats(statsRequest);

        player.setStats(stats);

        stats.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);

        return StatsConverter.statsToStatsResponse(savedPlayer.getStats());
    }
}
