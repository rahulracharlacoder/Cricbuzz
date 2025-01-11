package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.StatsRequest;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    //Create Methods
    @PostMapping("/addStats")
    public ResponseEntity<?> getStats(@RequestBody StatsRequest statsRequest, @RequestParam int playerId) {
         return new ResponseEntity<>(statsService.getStats(statsRequest, playerId), HttpStatus.CREATED);
    }


    //Read Methods
    @GetMapping("/getById/{player_id}")
    public ResponseEntity<?> getById(@PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.getById(player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Update Methods
    @PutMapping("/updateStats/{player_id}")
    public ResponseEntity<?> updateStats(@RequestBody StatsRequest statsRequest, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.updateStats(statsRequest, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateRuns/{player_id}")
    public ResponseEntity<?> updateRuns(@RequestParam int runs, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.updateRuns(runs, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateWickets/{player_id}")
    public ResponseEntity<?> updateWickets(@RequestParam int wickets, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.updateWickets(wickets, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateBattingAverage/{player_id}")
    public ResponseEntity<?> updateBattingAverage(@RequestParam double battingAverage, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.updateBattingAverage(battingAverage, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateBowlingAverage/{player_id}")
    public ResponseEntity<?> updateBowlingAverage(@RequestParam double bowlingAverage, @PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.updateBowlingAverage(bowlingAverage, player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Delete Method
    @DeleteMapping("/deleteStats/{player_id}")
    public ResponseEntity<?> deleteStats(@PathVariable int player_id) {
        try{
            return new ResponseEntity<>(statsService.deleteStats(player_id), HttpStatus.FOUND);
        }
        catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
