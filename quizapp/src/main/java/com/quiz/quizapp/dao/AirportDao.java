package com.quiz.quizapp.dao;
import com.quiz.quizapp.Airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface AirportDao extends JpaRepository<Airport,Integer> {

}
