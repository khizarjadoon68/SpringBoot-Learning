package in.strikes.crrudDtoDemo.service;

import in.strikes.crrudDtoDemo.entity.Student;
import in.strikes.crrudDtoDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository ;

    public StudentService (StudentRepository studentRepository){

        this.studentRepository = studentRepository ;

    }

    public Student createStudent(Student studentReq) {

        return studentRepository.save(studentReq);

    }
}
