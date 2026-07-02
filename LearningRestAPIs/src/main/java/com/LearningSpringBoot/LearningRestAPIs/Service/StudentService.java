package com.LearningSpringBoot.LearningRestAPIs.Service;

import com.LearningSpringBoot.LearningRestAPIs.DTO.AddStudentRequestDto;
import com.LearningSpringBoot.LearningRestAPIs.DTO.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents ();

     StudentDto getStudentsById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    Object updatePartialStudent(Long id, Map<String, Object> updates);
}
