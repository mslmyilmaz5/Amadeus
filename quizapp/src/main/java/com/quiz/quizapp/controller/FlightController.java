package com.quiz.quizapp.controller;


import com.quiz.quizapp.Flight;


import com.quiz.quizapp.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("flight")
@Schema(name = "flight", description = "Fligthts")
public class FlightController
{

    @Autowired
    FlightService flightService;


    @GetMapping("get/{id}")
    @Schema(name = "id", description = "Product id", example = "123e4567-e89b-12d3-a456-426614174000")
    public List<Flight> getId(@PathVariable int id){
        return flightService.getFlight(id);
    }

    @PostMapping("add")

    public String addName(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @DeleteMapping("delete/{id}")

    public String deleteFlight(@PathVariable int id) {
        return flightService.deleteFlight(id);
    }

    @PutMapping("update/{id}")

    public String updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }
    @GetMapping("searchByDeparture/{departureId}")


    public List<Flight> searchFlightsByDestinationAirport(@PathVariable int departureId){
        return flightService.getFlightsByDepartureId(departureId);
    }

    @GetMapping("searchByArrival/{arrivalId}")

    public List<Flight> searchFlightsByArrivalAirport(@PathVariable int arrivalId){
        return flightService.getFlightsByAirportId(arrivalId);
    }

    @GetMapping("searchByDepartureDate/{date}")

    public List<Flight> searchFlightsByDepartureDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return flightService.getFlightsByDepartureDate(date);
    }

    @GetMapping("searchByReturnDate/{date}")

    public List<Flight> searchFlightsByReturnDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return flightService.getFlightsByReturnDate(date);
    }


}
