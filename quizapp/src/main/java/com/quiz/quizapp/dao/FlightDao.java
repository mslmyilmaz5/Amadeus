package com.quiz.quizapp.dao;

import com.quiz.quizapp.Flight;
import jakarta.persistence.TemporalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface FlightDao extends JpaRepository<Flight,Integer> {


    List<Flight> findByDepartureAirportId(int i);

    List<Flight> findByArrivalAirportId(int i);

    @Query("SELECT f FROM Flight f WHERE CAST(f.departureDateTime AS date) = :date")
    List<Flight> findByDepartureDateTime(@Param("date") @Temporal(TemporalType.DATE) Date date);

    @Query("SELECT f FROM Flight f WHERE CAST(f.returnDateTime AS date) = :date")
    List<Flight> findByReturnDateTime(@Param("date") @Temporal(TemporalType.DATE) Date date);

    List<Flight> findByRelatedFlightId(int relatedFlightId);
}
