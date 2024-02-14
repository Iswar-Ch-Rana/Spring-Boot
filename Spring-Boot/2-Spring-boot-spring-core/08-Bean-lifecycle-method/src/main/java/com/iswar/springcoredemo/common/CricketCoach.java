package com.iswar.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {
    // Define our INIT Methods
    @PostConstruct
    public void doAfterStartingApp(){
        System.out.println("In doAfterStartingApp(): " + getClass().getSimpleName());
    }
    // Define our Destroy Methods
    @PreDestroy
    public void doBeforeDestroyingApp(){
        System.out.println("In doBeforeDestroyingApp(): " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice First Bowling for 15 minutes!";
    }
}
