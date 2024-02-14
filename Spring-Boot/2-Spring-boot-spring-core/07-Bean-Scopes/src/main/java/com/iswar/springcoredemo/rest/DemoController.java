package com.iswar.springcoredemo.rest;

import com.iswar.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach ;
    private final Coach anotherCoach ;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach){
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkScope(){
        return "Comparing beans : myCoach == anotherCoach , " + (myCoach == anotherCoach) ;
    }
}
