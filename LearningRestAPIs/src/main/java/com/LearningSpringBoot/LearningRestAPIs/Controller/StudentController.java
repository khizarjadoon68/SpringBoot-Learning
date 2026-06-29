package com.LearningSpringBoot.LearningRestAPIs.Controller;

import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//It handles http requests and returns the response directly to the client .
// It registers a class as a Bean .
@RestController
public class StudentController {

    //It is a  used to handle HTTP GET requests.
    //It is commonly used to retrieve data from the server.
    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(7,"khizar ","khizar68@gmail.com");
    }
}
