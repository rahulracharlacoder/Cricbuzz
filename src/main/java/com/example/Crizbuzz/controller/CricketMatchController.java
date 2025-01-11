package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.CricketMatchRequest;
import com.example.Crizbuzz.exception.CricketMatchNotFoundException;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.service.CricketMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/cricketMatch")
public class CricketMatchController {
    @Autowired
    CricketMatchService cricketMatchService;

    //Create Methods
    @PostMapping("/addMatches")
    public ResponseEntity<?> addMatches(@RequestBody CricketMatchRequest cricketMatchRequest,
                                        @RequestParam int teamAId, @RequestParam int teamBId) {
        try {
            return new ResponseEntity<>(cricketMatchService.addMatches(cricketMatchRequest,
                    teamAId, teamBId), HttpStatus.CREATED);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    //Read Methods
    @GetMapping("/getAllMatches")
    public ResponseEntity<?> getAllMatches() {
        return new ResponseEntity<>(cricketMatchService.getAllMatches(), HttpStatus.FOUND);
    }

    @GetMapping("/getById/{cricketMatch_id}")
    public ResponseEntity<?> getById(@PathVariable int cricketMatch_id) {
        try {
            return new ResponseEntity<>(cricketMatchService.getById(cricketMatch_id), HttpStatus.FOUND);
        } catch (CricketMatchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<?> getByTitle(@RequestParam String title) {
        return new ResponseEntity<>(cricketMatchService.getByTitle(title), HttpStatus.FOUND);
    }

    @GetMapping("/getByVenue")
    public ResponseEntity<?> getByVenue(@RequestParam String venue) {
        return new ResponseEntity<>(cricketMatchService.getByVenue(venue), HttpStatus.FOUND);
    }

    @GetMapping("/getByDate")
    public ResponseEntity<?> getByDate(@RequestParam Date matchDate) {
        return new ResponseEntity<>(cricketMatchService.getByDate(matchDate), HttpStatus.FOUND);
    }

    @GetMapping("/getStartToEndDateRange")
    public ResponseEntity<?> getStartToEndDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return new ResponseEntity<>(cricketMatchService.getStartToEndDateRange(startDate, endDate), HttpStatus.FOUND);
    }

    @PutMapping("/updateMatch/{match_id}")
    public ResponseEntity<?>  updateMatch(@PathVariable int match_id, @RequestBody CricketMatchRequest cricketMatchRequest) {
        try {
            return new ResponseEntity<>(cricketMatchService.updateMatch(match_id, cricketMatchRequest), HttpStatus.FOUND);
        } catch (CricketMatchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Update Methods
    @PutMapping("/updateTitle/{match_id}")
    public ResponseEntity<?>  updateTitle(@PathVariable int match_id, @RequestParam String title) {
        try {
            return new ResponseEntity<>(cricketMatchService.updateTitle(match_id, title), HttpStatus.FOUND);
        } catch (CricketMatchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateVenue/{match_id}")
    public ResponseEntity<?> updateVenue(@PathVariable int match_id, @RequestParam String venue) {
        try {
            return new ResponseEntity<>(cricketMatchService.updateVenue(match_id, venue), HttpStatus.FOUND);
        } catch (CricketMatchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //Delete Method
    @DeleteMapping("deleteMatch/{match_id}")
    public ResponseEntity<?>  deleteMatch(@PathVariable int match_id) {
        try {
            return new ResponseEntity<>(cricketMatchService.deleteMatch(match_id), HttpStatus.FOUND);
        } catch (CricketMatchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}