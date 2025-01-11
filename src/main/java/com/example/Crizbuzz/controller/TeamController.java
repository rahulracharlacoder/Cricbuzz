package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.TeamRequest;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    //Create methods
    @PostMapping("/addTeam")
    public ResponseEntity<?> addTeam(@RequestBody TeamRequest teamRequest) {
        return new ResponseEntity<>(teamService.addTeam(teamRequest), HttpStatus.CREATED);
    }


    //Read methods
    @GetMapping("/getTeam/{team_id}")
    public ResponseEntity<?> getTeam(@PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.getTeam(team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllTeams")
    public ResponseEntity<?> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.FOUND);
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        return new ResponseEntity<>(teamService.getByName(name), HttpStatus.FOUND);
    }

    @GetMapping("/getByRanking")
    public ResponseEntity<?> getByRanking(@RequestParam int ranking) {
        return new ResponseEntity<>(teamService.getByRanking(ranking), HttpStatus.FOUND);
    }

    @GetMapping("/getByIccPoints")
    public ResponseEntity<?> getByIccPoints(@RequestParam int iccPoints) {
        return new ResponseEntity<>(teamService.getByIccPoints(iccPoints), HttpStatus.FOUND);
    }

    @GetMapping("/getByCoach")
    public ResponseEntity<?> getByCoach(@RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByCoach(coach), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAndRanking")
    public ResponseEntity<?> getByNameAndRanking(@RequestParam String name, @RequestParam int ranking) {
        return new ResponseEntity<>(teamService.getByNameAndRanking(name, ranking), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAndIccPoints")
    public ResponseEntity<?> getByNameAndIccPoints(@RequestParam String name, @RequestParam int iccPoints) {
        return new ResponseEntity<>(teamService.getByNameAndIccPoints(name, iccPoints), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameAndCoach")
    public ResponseEntity<?> getByNameAndCoach(@RequestParam String name, @RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByNameAndCoach(name, coach), HttpStatus.FOUND);
    }

    @GetMapping("/getByRankingAndIccPoints")
    public ResponseEntity<?> getByRankingAndIccPoints(@RequestParam int ranking, @RequestParam int iccPoints) {
        return new ResponseEntity<>(teamService.getByRankingAndIccPoints(ranking, iccPoints), HttpStatus.FOUND);
    }

    @GetMapping("/getByRankingAndCoach")
    public ResponseEntity<?> getByRankingAndCoach(@RequestParam int ranking, @RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByRankingAndCoach(ranking, coach), HttpStatus.FOUND);
    }

    @GetMapping("/getByIccPointsAndCoach")
    public ResponseEntity<?> getByIccPointsAndCoach(@RequestParam int iccPoints, @RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByIccPointsAndCoach(iccPoints, coach), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameRankingAndIccPoints")
    public ResponseEntity<?> getByNameRankingAndIccPoints(@RequestParam String name, @RequestParam int ranking, @RequestParam int iccPoints) {
        return new ResponseEntity<>(teamService.getByNameRankingAndIccPoints(name, ranking, iccPoints), HttpStatus.FOUND);
    }

    @GetMapping("/getByNameRankingAndCoach")
    public ResponseEntity<?> getByNameRankingAndCoach(@RequestParam String name, @RequestParam int ranking, @RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByNameRankingAndCoach(name, ranking, coach), HttpStatus.FOUND);
    }

    @GetMapping("/getByRankingIccPointsAndCoach")
    public ResponseEntity<?> getByRankingIccPointsAndCoach(@RequestParam int ranking, @RequestParam int iccPoints, @RequestParam String coach) {
        return new ResponseEntity<>(teamService.getByRankingIccPointsAndCoach(ranking, iccPoints, coach), HttpStatus.FOUND);
    }


    //Update methods
    @PutMapping("/updateTeam/{team_id}")
    public ResponseEntity<?> updateTeam(@RequestBody TeamRequest teamRequest, @PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.updateTeam(teamRequest, team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateName/{team_id}")
    public ResponseEntity<?> updateName(@RequestParam String name, @PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.updateName(name, team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateRanking/{team_id}")
    public ResponseEntity<?> updateRanking(@RequestParam int ranking, @PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.updateRanking(ranking, team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateIccPoints/{team_id}")
    public ResponseEntity<?> updateIccPoints(@RequestParam int iccPoints, @PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.updateIccPoints(iccPoints, team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateCoach/{team_id}")
    public ResponseEntity<?> updateCoach(@RequestParam String coach, @PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.updateCoach(coach, team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Delete methods
    @DeleteMapping("/deleteTeam/{team_id}")
    public ResponseEntity<?> deleteTeam(@PathVariable int team_id) {
        try{
            return new ResponseEntity<>(teamService.deleteTeam(team_id), HttpStatus.FOUND);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
