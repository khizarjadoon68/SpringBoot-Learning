package com.example.EmployeeManegement.repository;

import com.example.EmployeeManegement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
