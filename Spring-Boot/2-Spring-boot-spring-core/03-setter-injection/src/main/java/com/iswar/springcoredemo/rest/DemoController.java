package com.iswar.springcoredemo.rest;

import com.iswar.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define private field for dependency
    private Coach myCoach ;
    // Constructor for dependency Injection
    @Autowired
    public void setCoach(Coach myCoach){
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
