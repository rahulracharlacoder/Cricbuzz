package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.PlayerConverter;
import com.example.Crizbuzz.dto.request.PlayerRequest;
import com.example.Crizbuzz.dto.response.PlayerResponse;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.model.Player;
import com.example.Crizbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConverter.PlayerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        return PlayerConverter.playerToPlayerResponse(savedPlayer);
    }

    public PlayerResponse getPlayer(int player_id) {
        Optional<Player> playerOptional = playerRepository.findById(player_id);
        if(playerOptional.isEmpty()) {
            throw new PlayerNotFoundException("Player witd id "+player_id+" doesn't exist");
        }
        return PlayerConverter.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> getPlayerByGenderAndAge(Gender gender, int age) {
        List<Player> players = playerRepository.findByGenderAndAgeGreaterThan(gender, age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndSpeciality(Gender gender, Speciality speciality) {
        List<Player> players = playerRepository.getByGenderAndSpeciality(gender, speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }
}
