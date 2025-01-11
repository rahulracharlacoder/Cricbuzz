package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.PlayerRequest;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //Create Method
    @PostMapping("/addPlayer")
    public ResponseEntity<?> addPlayer(@RequestBody PlayerRequest playerRequest){
        return new ResponseEntity<>(playerService.addPlayer(playerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/addPlayerInTeam/{team_id}/{player_id}")
    public ResponseEntity<?> addPlayerInTeam(@PathVariable int team_id, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.addPlayerInTeam(team_id, player_id), HttpStatus.CREATED);
        }
        catch (TeamNotFoundException | PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Read Methods
    @GetMapping("/getAllPlayers")
    public ResponseEntity<?> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.FOUND);
    }

    @GetMapping("/player_id/{player_id}")
    public ResponseEntity<?> getPlayer(@PathVariable int player_id){
        try {
            return new ResponseEntity<>(playerService.getPlayer(player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        return new ResponseEntity<>(playerService.getByName(name), HttpStatus.FOUND);
    }

    @GetMapping("/getByAge")
    public ResponseEntity<?> getByName(@RequestParam int age) {
        return new ResponseEntity<>(playerService.getByAge(age), HttpStatus.FOUND);
    }

    @GetMapping("/getBySpeciality")
    public ResponseEntity<?> getBySpeciality(@RequestParam Speciality speciality) {
        return new ResponseEntity<>(playerService.getBySpeciality(speciality), HttpStatus.FOUND);
    }

    @GetMapping("/getByGender")
    public ResponseEntity<?> getByGender(@RequestParam Gender gender) {
        return new ResponseEntity<>(playerService.getByGender(gender), HttpStatus.FOUND);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email) {
        try {
            return new ResponseEntity<>(playerService.getByEmail(email), HttpStatus.OK);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/genderAndName")
    public ResponseEntity<?> getByGenderAndName(@RequestParam Gender gender, @RequestParam String name) {
        return new ResponseEntity<>(playerService.getByGenderAndName(gender, name), HttpStatus.FOUND);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<?> getPlayerByGenderAndAge(@PathVariable Gender gender, @PathVariable int age) {
        return new ResponseEntity<>(playerService.getPlayerByGenderAndAge(gender, age), HttpStatus.FOUND);
    }

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public ResponseEntity<?> getPlayerByGenderAndSpeciality(@PathVariable Gender gender, @PathVariable Speciality speciality) {
        return new ResponseEntity<>(playerService.getPlayerByGenderAndSpeciality(gender, speciality), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAndAge")
    public ResponseEntity<?> getByNameAndAge(@RequestParam String name, @RequestParam int age) {
        return new ResponseEntity<>(playerService.getByNameAndAge(name, age), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAndSpeciality")
    public ResponseEntity<?> getByNameAndSpeciality(@RequestParam String name, @RequestParam Speciality speciality) {
        return new ResponseEntity<>(playerService.getByNameAndSpeciality(name, speciality), HttpStatus.FOUND);
    }

    @GetMapping("/getByAgeAndSpeciality")
    public ResponseEntity<?> getByAgeAndSpeciality(@RequestParam int age, @RequestParam Speciality speciality) {
        return new ResponseEntity<>(playerService.getByAgeAndSpeciality(age, speciality), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAgeAndSpeciality")
    public ResponseEntity<?> getByNameAgeAndSpeciality(@RequestParam String name, @RequestParam int age, @RequestParam Speciality speciality) {
        return new ResponseEntity<>(playerService.getByNameAgeAndSpeciality(name, age, speciality), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAgeAndGender")
    public ResponseEntity<?> getByNameAgeAndGender(@RequestParam String name, @RequestParam int age, @RequestParam Gender gender) {
        return new ResponseEntity<>(playerService.getByNameAgeAndGender(name, age, gender), HttpStatus.FOUND);
    }


    //Update Methods
    @PutMapping("/updatePlayer/{player_id}")
    public ResponseEntity<?> updatePlayer(@RequestBody PlayerRequest playerRequest, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updatePlayer(playerRequest, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateName/{player_id}")
    public ResponseEntity<?> updateName(@RequestParam String name, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updateName(name, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateAge/{player_id}")
    public ResponseEntity<?> updateAge(@RequestParam int age, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updateAge(age, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateSpeciality/{player_id}")
    public ResponseEntity<?> updateSpeciality(@RequestParam Speciality speciality, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updateSpeciality(speciality, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("updateGender/{player_id}")
    public ResponseEntity<?> updateGender(@RequestParam Gender gender, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updateGender(gender, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("updateEmail/{player_id}")
    public ResponseEntity<?> updateEmail(@RequestParam String email, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.updateEmail(email, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Delete methods
    @DeleteMapping("/deletePlayer/{player_id}")
    public ResponseEntity<?> deletePlayer(@PathVariable int player_id) {
        try{
            return new ResponseEntity<>(playerService.deletePlayer(player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
