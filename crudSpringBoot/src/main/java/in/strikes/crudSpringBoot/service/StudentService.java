package in.strikes.crudSpringBoot.service;

import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository ;

    public StudentService (StudentRepository studentRepository){
            this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq) {

        Student studentResp = studentRepository.save(studentReq);
        return studentReq ;
    }


    public Student getStudent(Long id) {
        Optional<Student> studentRes = studentRepository.findById(id);
        if (studentRes.isPresent()){
            return studentRes.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isEmpty()){
            return null ;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) return false ;

        studentRepository.deleteById(id);
        return true ;
    }
}











