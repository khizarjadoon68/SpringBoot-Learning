package com.LearningSpringBoot.LearningRestAPIs.Service.Impl;


import com.LearningSpringBoot.LearningRestAPIs.DTO.AddStudentRequestDto;
import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Entity.Student;
import com.LearningSpringBoot.LearningRestAPIs.Repository.StudentRepository;
import com.LearningSpringBoot.LearningRestAPIs.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor //It Creates Constructor automatically for final .
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository ;

    private final ModelMapper modelMapper ;

    @Override
    public List<StudentDto> getAllStudents (){
        List<Student> students = studentRepository.findAll() ;
        List<StudentDto> studentDtoList =students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtoList ;
    }

    @Override
    public StudentDto getStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student Not Found With Id :"+id));
        return modelMapper.map(student, StudentDto.class) ;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto ,Student.class) ;
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student ,StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found by this id :"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Student Not Found With Id :"+id));
        modelMapper.map(addStudentRequestDto , student);
        student =   studentRepository.save(student);
        return modelMapper.map(student ,StudentDto.class);
    }

    @Override
    public Object updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Student Not Found With Id :"+id));
        updates.forEach((field ,value) -> {
            switch (field) {
                case "name" :student.setName((String) value);
                case "email" :student.setEmail((String) value);
                default:throw new IllegalArgumentException("Field is nor supported");
            }
        });
        Student savedStudent=studentRepository.save(student);
        return modelMapper.map(savedStudent ,StudentDto.class);
    }


}
