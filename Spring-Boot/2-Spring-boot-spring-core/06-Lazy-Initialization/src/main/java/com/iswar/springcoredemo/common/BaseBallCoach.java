package com.iswar.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
//@Lazy // This will Not Initialize the class if it's not required
public class BaseBallCoach implements Coach {
    public BaseBallCoach (){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice Batting for 30 minutes!";
    }
}
