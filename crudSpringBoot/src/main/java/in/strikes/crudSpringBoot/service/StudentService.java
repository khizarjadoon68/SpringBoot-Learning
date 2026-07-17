package in.strikes.crudSpringBoot.service;

import in.strikes.crudSpringBoot.Dto.CreateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.CreateStudentResponseDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBoot.Dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.exception.ResourceNotFoundException;
import in.strikes.crudSpringBoot.exception.duplicateResourceException;
import in.strikes.crudSpringBoot.repository.StudentRepository;
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

        if (emailExist(student)){
            throw new duplicateResourceException("Student with this email "+student.getEmail()+" already exist");
        }

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
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
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
        Student studentRes = studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id " + id + " not found"));

        return mapToDto(studentRes) ;

    }

    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToDto)
                .toList();


    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
       Student existingStudent = studentRepository
               .findByIdAndDeletedIsFalse(id)
               .orElseThrow(() ->
                       new ResourceNotFoundException("Student with id "+id+" not found"));

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);
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

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found")) ;

        studentRepository.delete(studentToBeDeleted) ;
    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id "+id+" not found")) ;

        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Boolean emailExist(Student student){

       return studentRepository.existsByEmail(student.getEmail());

    }

}











