package com.iswar.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // We can have one primary and @Primary has lower priority then @Qualifier
public class BaseBallCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice Batting for 30 minutes!";
    }
}
