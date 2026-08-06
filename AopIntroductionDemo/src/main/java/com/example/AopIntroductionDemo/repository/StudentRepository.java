package com.example.AopIntroductionDemo.repository;

import com.example.AopIntroductionDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student Saved");
    }
}