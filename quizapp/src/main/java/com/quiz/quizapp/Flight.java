package com.quiz.quizapp;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date_time")
    private Date departureDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date_time")
    private Date returnDateTime;

    private double price;

    private int relatedFlightId;
}
