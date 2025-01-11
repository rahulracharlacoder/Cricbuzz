package com.example.Crizbuzz.converter;

import com.example.Crizbuzz.dto.request.PlayerRequest;
import com.example.Crizbuzz.dto.response.PlayerResponse;
import com.example.Crizbuzz.model.Player;

public class PlayerConverter {

    public static Player PlayerRequestToPlayer(PlayerRequest playerRequest) {
        return Player.builder().
                name(playerRequest.getName()).
                age(playerRequest.getAge()).
                speciality(playerRequest.getSpeciality()).
                gender(playerRequest.getGender()).
                email(playerRequest.getEmail()).
                build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player) {
        return PlayerResponse.builder().
                name(player.getName()).
                speciality(player.getSpeciality()).
                build();
    }
}
