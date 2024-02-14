package com.iswar.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
// If we use Prototype here then it will create different beans for different injection
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice First Bowling for 15 minutes!";
    }
}
