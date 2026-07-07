package in.strikes.crudSpringBoot.controller;

import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.service.StudentService;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student ){
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent) ;
    }


    @GetMapping ("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentRes = studentService.getStudent(id);

        if (studentRes == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRes);
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if (studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id ,
                                                 @RequestBody Student studentReq){

         Student studentRes=studentService.updateStudent(id ,studentReq );

         if (studentRes==null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id){
      boolean  isDeleted = studentService.deleteStudent(id);

      if (!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return  ResponseEntity.ok("Record Deleted");

    }
}
