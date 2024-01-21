package com.quiz.quizapp.controller;


import com.quiz.quizapp.Airport;

import com.quiz.quizapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("airport")

public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("get/{id}")
    public Airport getId(@PathVariable int id){
        return airportService.getAirport(id);
    }

    @PostMapping("add")
    public String addName(@RequestBody Airport airport){
        return airportService.addAirport(airport);
    }

    @PutMapping("update/{id}")
    public String updateAirport(@PathVariable int id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }
    @DeleteMapping("delete/{id}")
    public String deleteAirport(@PathVariable int id) {
        return airportService.deleteAirport(id);
    }

}
