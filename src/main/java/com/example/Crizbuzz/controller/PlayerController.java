package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.PlayerRequest;
import com.example.Crizbuzz.dto.response.PlayerResponse;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.model.Player;
import com.example.Crizbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/addPlayer")
    public ResponseEntity addPlayer(@RequestBody PlayerRequest playerRequest){
        return new ResponseEntity<>(playerService.addPlayer(playerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/player_id/{player_id}")
    public ResponseEntity getPlayer(@PathVariable int player_id){
        try {
            return new ResponseEntity<>(playerService.getPlayer(player_id), HttpStatus.OK);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getPlayerByGenderAndAge(@PathVariable Gender gender, @PathVariable int age) {
        return playerService.getPlayerByGenderAndAge(gender, age);
    }

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getPlayerByGenderAndSpeciality(@PathVariable Gender gender, @PathVariable Speciality speciality) {
        return playerService.getPlayerByGenderAndSpeciality(gender, speciality);
    }
}
