package in.strikes.crudSpringBoot.service;

import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository ;

    public StudentService (StudentRepository studentRepository){
            this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service");

        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service");
        return studentReq ;
    }



}
