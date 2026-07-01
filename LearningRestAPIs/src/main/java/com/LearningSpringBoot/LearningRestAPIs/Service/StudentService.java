package com.LearningSpringBoot.LearningRestAPIs.Service;

import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents ();

     StudentDto getStudentsById(Long id);
}
