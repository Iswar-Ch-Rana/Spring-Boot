package com.demo.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
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
