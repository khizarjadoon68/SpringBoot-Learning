package com.example.demoJdbc;

import com.example.demoJdbc.model.Student;
import com.example.demoJdbc.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJdbcApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DemoJdbcApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {

        studentRepository.createStudentTable();

        Student student = new Student(
                "Khizar",
                "khizar@gmail.com",
                24
        );

        studentRepository.saveStudent(student);
    }
}