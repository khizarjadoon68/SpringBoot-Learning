package in.strikes.crudSpringBoot.controller;

import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/students")
public class StudentController {

    private StudentService studentService ;

    public StudentController(StudentService studentService){
        this.studentService = studentService ;
    }

    //Create Student
    @PostMapping ("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student ){
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent) ;
    }

}
