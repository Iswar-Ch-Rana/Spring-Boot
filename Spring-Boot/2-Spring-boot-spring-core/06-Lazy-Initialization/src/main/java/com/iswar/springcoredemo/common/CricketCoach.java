package com.iswar.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
//@Lazy // This will Not Initialize the class if it's not required
public class CricketCoach implements Coach {
    public CricketCoach (){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice First Bowling for 15 minutes!";
    }
}
