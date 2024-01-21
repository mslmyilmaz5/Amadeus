package com.quiz.quizapp.service;

import com.quiz.quizapp.Airport;
import com.quiz.quizapp.dao.AirportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    AirportDao airportDao;
    public Airport getAirport(int id) {
        return airportDao.findById(id).orElse(null);
    }
    public String addAirport(Airport airport) {
        airportDao.save(airport);
        return "Airport Successfully added";
    }


    public String updateAirport(int id, Airport newAirport) {
        Optional<Airport> existingAirportOptional = airportDao.findById(id);
        if (existingAirportOptional.isPresent()) {
            Airport existingAirport = existingAirportOptional.get();
            existingAirport.setCity(newAirport.getCity());
            return "Airport Successfully updated";
        }
        else {
            return "Airport with ID " + id + " not found";
        }
    }

    public String deleteAirport(int id) {
        airportDao.deleteById(id);
        return "Airport Successfully deleted";
    }
}
