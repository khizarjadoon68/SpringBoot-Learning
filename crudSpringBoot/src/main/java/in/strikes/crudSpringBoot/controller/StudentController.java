package in.strikes.crudSpringBoot.controller;

import in.strikes.crudSpringBoot.Dto.CreateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.CreateStudentResponseDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/students")
public class StudentController {

    private StudentService studentService ;

    public StudentController(StudentService studentService){
        this.studentService = studentService ;
    }

    //Create Student
    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
           @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto){

        CreateStudentResponseDto createStudent = studentService.createStudent(createStudentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent) ;
    }


    @GetMapping ("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudentById(@PathVariable Long id){
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentRequestDto> updateStudent(@RequestParam Long id ,
                                                 @RequestBody UpdateStudentRequestDto studentRes){

         UpdateStudentResponseDto studentResp=
                 studentService.updateStudent(id ,studentRes );

         return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteStudent (@RequestParam Long id){
     studentService.deleteStudent(id);
      return  ResponseEntity
              .noContent()
              .build();
    }

    @PatchMapping ("delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly (@RequestParam Long id){
       studentService.deleteStudentSoftly(id);

        return ResponseEntity
                .noContent()
                .build();
    }


}
