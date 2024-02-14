package com.iswar.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice First Bowling for 15 minutes!";
    }
}
