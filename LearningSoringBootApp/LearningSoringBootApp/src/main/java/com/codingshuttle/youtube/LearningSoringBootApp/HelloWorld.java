package com.codingshuttle.youtube.LearningSoringBootApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello (){
        return "Hello World From Khizar Ali";
    }
}
