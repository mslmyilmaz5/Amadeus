package com.quiz.quizapp.service;

import com.quiz.quizapp.Flight;
import com.quiz.quizapp.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {

    @Autowired
    FlightDao flightDao;


    public String addFlight(Flight flight) {
        flightDao.save(flight);
        Random ran = new Random();
        int relatedId = Math.abs(ran.nextInt());
        flight.setRelatedFlightId(relatedId);
        if (flight.getReturnDateTime() != null)
        {
            Flight returnFlight = new Flight();
            returnFlight.setDepartureAirport(flight.getArrivalAirport());
            returnFlight.setArrivalAirport(flight.getDepartureAirport());
            returnFlight.setDepartureDateTime(flight.getReturnDateTime());
            returnFlight.setPrice(flight.getPrice());
            returnFlight.setRelatedFlightId(relatedId);
            flightDao.save(returnFlight);

        }
        return "Flight Successfully added";
    }
    public String deleteFlight(int id) {
        flightDao.deleteById(id);
        return "Flight Successfully deleted";
    }

    public String updateFlight(int id, Flight newFlight) {

        Optional<Flight> existingFlightOptional = flightDao.findById(id);
        if (existingFlightOptional.isPresent()) {
            Flight existingFlight = existingFlightOptional.get();

            existingFlight.setDepartureAirport(newFlight.getDepartureAirport());
            existingFlight.setArrivalAirport(newFlight.getArrivalAirport());
            existingFlight.setDepartureDateTime(newFlight.getDepartureDateTime());
            existingFlight.setReturnDateTime(newFlight.getReturnDateTime());
            existingFlight.setPrice(newFlight.getPrice());

            flightDao.save(existingFlight);

            return "Flight Successfully updated";
        } else {
            return "Flight with ID " + id + " not found";
        }
    }

    public List<Flight> getFlight(int id) {
       Flight flight = flightDao.findById(id).orElse(null);
       if (flight != null) {
           int RelatedId = flight.getRelatedFlightId();
           if ( RelatedId != 0) {
               return flightDao.findByRelatedFlightId(RelatedId);
           }
           else {
               return Collections.singletonList(flight);
           }
       }
       return Collections.emptyList();
    }
    public List<Flight> getFlightsByDepartureId(int id){
        return flightDao.findByDepartureAirportId(id);
    }

    public List<Flight> getFlightsByAirportId(int id){
        return flightDao.findByArrivalAirportId(id);
    }

    public List<Flight> getFlightsByDepartureDate(Date date) {
        return flightDao.findByDepartureDateTime(date);
    }

    public List<Flight> getFlightsByReturnDate(Date date) {
        return flightDao.findByReturnDateTime(date);
    }
}
