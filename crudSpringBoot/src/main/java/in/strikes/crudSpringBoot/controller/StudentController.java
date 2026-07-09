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
    @PostMapping ("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(
           @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto){

        CreateStudentResponseDto createStudent = studentService.createStudent(createStudentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent) ;
    }


    @GetMapping ("/get/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentRes = studentService.getStudent(id);

        if (studentRes == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRes);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getStudent() {

        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentRequestDto> updateStudent(@PathVariable Long id ,
                                                 @RequestBody UpdateStudentRequestDto updateStudentRequestDto){

         UpdateStudentResponseDto studentRes=studentService.
                 updateStudent(id ,updateStudentRequestDto );

         if (studentRes==null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(updateStudentRequestDto);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id){
      boolean  isDeleted = studentService.deleteStudent(id);

      if (!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return  ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping ("delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly (@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if (!isDeleted)return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record Deleted");
    }


}
