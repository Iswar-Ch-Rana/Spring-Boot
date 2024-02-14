package com.iswar.springcoredemo.rest;

import com.iswar.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Lazy // This will Not Initialize the class if it's not required

// We can set Lazy in Properties of the application also

public class DemoController {
    private final Coach myCoach ;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
