package com.example.Crizbuzz.converter;

import com.example.Crizbuzz.dto.request.StatsRequest;
import com.example.Crizbuzz.dto.response.StatsResponse;
import com.example.Crizbuzz.model.Stats;

public class StatsConverter {
    public static Stats statsRequestToStats(StatsRequest statsRequest) {
        return Stats.builder().
                runs(statsRequest.getRuns()).
                wickets(statsRequest.getWickets()).
                battingAverage(statsRequest.getBattingAverage()).
                bowlingAverage(statsRequest.getBowlingAverage()).
                build();
    }

    public static StatsResponse statsToStatsResponse(Stats stats) {
        return StatsResponse.builder().
                runs(stats.getRuns()).
                wickets(stats.getWickets()).
                player(PlayerConverter.playerToPlayerResponse(stats.getPlayer())).
                build();
    }
}
