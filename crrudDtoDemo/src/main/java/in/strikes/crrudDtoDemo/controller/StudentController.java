package in.strikes.crrudDtoDemo.controller;

import in.strikes.crrudDtoDemo.entity.Student;
import in.strikes.crrudDtoDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/students")
public class StudentController {

    private StudentService studentService ;

    public StudentController (StudentService studentService){
        this.studentService = studentService ;
    }



public ResponseEntity<Student> create (@RequestBody Student student){
    Student studentRes = studentService.createStudent(student);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(studentRes);

}

}
