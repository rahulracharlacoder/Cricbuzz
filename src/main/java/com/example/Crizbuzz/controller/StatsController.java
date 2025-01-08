package com.example.Crizbuzz.controller;

import com.example.Crizbuzz.dto.request.StatsRequest;
import com.example.Crizbuzz.dto.response.StatsResponse;
import com.example.Crizbuzz.model.Stats;
import com.example.Crizbuzz.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    @PostMapping("/addStats")
    public StatsResponse getStats(@RequestBody StatsRequest statsRequest, @RequestParam int playerId) {
         return statsService.getStats(statsRequest, playerId);
    }
}
