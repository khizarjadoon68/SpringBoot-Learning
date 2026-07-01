package com.LearningSpringBoot.LearningRestAPIs.Controller;

import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//It handles http requests and returns the response directly to the client .
// It registers a class as a Bean .
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    //@GetMappingIt is a  used to handle HTTP GET requests.
    //It is commonly used to retrieve data from the server.
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentsById(id);


    }
}
