package in.strikes.filterDemo.controller;


import in.strikes.filterDemo.dto.Student;
import in.strikes.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/student")
public class StudentController {

    private StudentService studentService ;

    public StudentController(StudentService studentService){
        this.studentService = studentService ;
    }


    @PostMapping ("create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }

}
