package com.example.demoJdbc.repository;

import com.example.demoJdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudentTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS student (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    age INT
                )
                """;

        jdbcTemplate.execute(sql);

        System.out.println("Student table created successfully.");
    }

    public void saveStudent(Student student) {

        String sql = """
                INSERT INTO student(name, email, age)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge()
        );

        System.out.println("Student inserted successfully.");
    }
}
