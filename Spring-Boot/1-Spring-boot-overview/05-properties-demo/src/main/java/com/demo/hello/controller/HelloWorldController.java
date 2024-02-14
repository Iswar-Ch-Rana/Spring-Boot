package com.demo.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // accessing Environment variable
    @Value("${coach.name}")
    private String coachName ;
    @Value("${team.name}")
    private String teamName ;
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + " Team: " + teamName ;
    }





    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }
    @GetMapping("/about")
    public String about(){
        return "Welcome to about page !";
    }
    @GetMapping("/home")
    public String home(){
        return "Welcome to Home page !";
    }
}
