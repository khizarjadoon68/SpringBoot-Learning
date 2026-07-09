package in.strikes.crudSpringBoot.service;

import in.strikes.crudSpringBoot.Dto.CreateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.CreateStudentResponseDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository ;

    public StudentService (StudentRepository studentRepository){
            this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto) {
        Student student = mapToEntity(studentReqDto);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

       Student studentRes = studentRepository.save(student);

       return mapToDto(studentRes);

    }



    private Student mapToEntity(CreateStudentRequestDto studentReqDto) {

        Student student = new Student();
        student.setName(studentReqDto.getName());
        student.setRollNo(studentReqDto.getRollNo());
        student.setEmail(studentReqDto.getEmail());
        student.setAge(studentReqDto.getAge());
        student.setSubject(studentReqDto.getSubject());

        student.setDeleted(false);
        return student ;

    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setEmail(student.getEmail());
        responseDto.setAge(student.getAge());
        responseDto.setSubject(student.getSubject());
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        responseDto.setMessage("Student Save Successfully");

        return responseDto;
    }


    public CreateStudentResponseDto getStudent(Long id) {
        Optional<Student> studentRes = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentRes.isPresent()){
            return mapToDto(studentRes.get());
        }
        return null;
    }

    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();


        return studentList.stream()
                .map(this::mapToDto)
                .toList();


    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if (existingStudent.isEmpty()){
            return null ;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return mapToUpdateDto(savedStudent);

    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {

        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setEmail(student.getEmail());
        responseDto.setAge(student.getAge());
        responseDto.setSubject(student.getSubject());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        responseDto.setMessage("Student Save Successfully");

        return responseDto;

    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) return false ;

        studentRepository.deleteById(id);
        return true ;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if (existingStudent.isEmpty()){
            return false;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true ;

    }

}











