package com.example.Crizbuzz.converter;

import com.example.Crizbuzz.dto.request.TeamRequest;
import com.example.Crizbuzz.dto.response.TeamResponse;
import com.example.Crizbuzz.model.Team;

public class TeamConverter {
    public static Team TeamRequestToTeam(TeamRequest teamRequest) {
        return Team.builder().
                name(teamRequest.getName()).
                ranking(teamRequest.getRanking()).
                iccPoints(teamRequest.getIccPoints()).
                coach(teamRequest.getCoach()).
                build();
    }

    public static TeamResponse TeamToTeamResponse(Team team) {
        return TeamResponse.builder().
                name(team.getName()).
                ranking(team.getRanking()).
                iccPoints(team.getIccPoints()).
                coach(team.getCoach()).
                build();
    }
}
