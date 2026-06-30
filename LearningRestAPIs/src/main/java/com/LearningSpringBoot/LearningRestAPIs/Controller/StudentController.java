package com.LearningSpringBoot.LearningRestAPIs.Controller;

import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Entity.Student;
import com.LearningSpringBoot.LearningRestAPIs.Repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//It handles http requests and returns the response directly to the client .
// It registers a class as a Bean .
@RestController
public class StudentController {

    private final StudentRepository studentRepository ;

    public StudentController (StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }

    @GetMapping("/student")
    //@GetMappingIt is a  used to handle HTTP GET requests.
    //It is commonly used to retrieve data from the server.
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(7,"khizar ","khizar68@gmail.com");
    }
}
