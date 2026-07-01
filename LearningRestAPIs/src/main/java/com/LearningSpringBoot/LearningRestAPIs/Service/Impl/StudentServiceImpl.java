package com.LearningSpringBoot.LearningRestAPIs.Service.Impl;


import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Repository.StudentRepository;
import com.LearningSpringBoot.LearningRestAPIs.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.LearningSpringBoot.LearningRestAPIs.Entity.Student;

import java.util.List;
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
}
