package com.iswar.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
//@Lazy // This will Not Initialize the class if it's not required
public class TrackCoach implements Coach {
    public TrackCoach (){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Run 5 km !";
    }
}
