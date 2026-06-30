package com.LearningSpringBoot.LearningRestAPIs.Service.Impl;

import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;
import com.LearningSpringBoot.LearningRestAPIs.Service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentDto> getAllStudents (){
        return List.of() ;
    }
}
