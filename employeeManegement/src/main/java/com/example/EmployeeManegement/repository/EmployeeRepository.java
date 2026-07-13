package com.example.EmployeeManegement.repository;

import com.example.EmployeeManegement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByIdAndIsDeletedFalse(Long id);

    List<Employee> findByIsDeletedFalse();
}