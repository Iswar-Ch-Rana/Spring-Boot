package com.iswar.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice Batting for 30 minutes!";
    }
}
