package com.LearningSpringBoot.LearningRestAPIs.Controller;

import com.LearningSpringBoot.LearningRestAPIs.DTO.AddStudentRequestDto;
import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Entity.Student;
import com.LearningSpringBoot.LearningRestAPIs.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//It handles http requests and returns the response directly to the client .
// It registers a class as a Bean .
@RestController
@RequiredArgsConstructor//It creates constructor automatically for Final .
@RequestMapping ("/students") //
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    //@GetMappingIt is a  used to handle HTTP GET requests.
    //It is commonly used to retrieve data from the server.
    public ResponseEntity<List<StudentDto>> getAllStudents(){
//      return ResponseEntity.status(HttpStatus.OK ).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentsById(id));

    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteStudent (@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<StudentDto> updateStudent (@PathVariable Long id ,
                                                     @RequestBody @Valid AddStudentRequestDto addStudentRequestDto ){
        return ResponseEntity.ok(studentService.updateStudent(id , addStudentRequestDto)) ;
    }
    @PatchMapping ("/{id}")
    public StudentDto updatePartialStudent(@PathVariable Long id,
                                           @RequestBody Map<String , Object> updates) {
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }

}

