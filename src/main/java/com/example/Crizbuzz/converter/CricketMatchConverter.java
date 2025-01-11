package com.example.Crizbuzz.converter;

import com.example.Crizbuzz.dto.request.CricketMatchRequest;
import com.example.Crizbuzz.dto.response.CricketMatchResponse;
import com.example.Crizbuzz.dto.response.TeamResponse;
import com.example.Crizbuzz.model.CricketMatch;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CricketMatchConverter {

    public  static CricketMatch CricketMatchRequestToCricketMatch(CricketMatchRequest cricketMatchRequest) {
        return CricketMatch.builder().
                title(cricketMatchRequest.getTitle()).
                venue(cricketMatchRequest.getVenue()).
                teams(new ArrayList<>()).
                matchDate(new Date()).
                matchTime(new Time(System.currentTimeMillis())).
                build();
    }

    public static CricketMatchResponse CricketToCricketMatchResponse(CricketMatch cricketMatch) {

        List<TeamResponse> team =  new ArrayList<>();

        team.add(TeamConverter.TeamToTeamResponse(cricketMatch.getTeams().get(0)));
        team.add(TeamConverter.TeamToTeamResponse(cricketMatch.getTeams().get(1)));

        return CricketMatchResponse.builder().
                title(cricketMatch.getTitle()).
                venue(cricketMatch.getVenue()).
                matchDate(cricketMatch.getMatchDate()).
                matchTime(cricketMatch.getMatchTime()).
                teams(team).
                build();
    }
}
