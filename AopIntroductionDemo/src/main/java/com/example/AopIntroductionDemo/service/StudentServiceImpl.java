package com.example.AopIntroductionDemo.service;

import com.example.AopIntroductionDemo.dto.Student;
import com.example.AopIntroductionDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository =studentRepository ;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

}
