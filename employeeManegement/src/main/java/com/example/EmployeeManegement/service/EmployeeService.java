package com.example.EmployeeManegement.service;

import com.example.EmployeeManegement.dto.CreateEmployeeRequestDto;
import com.example.EmployeeManegement.dto.EmployeeResponseDto;
import com.example.EmployeeManegement.dto.UpdateEmployeeRequestDto;
import com.example.EmployeeManegement.entity.Employee;
import com.example.EmployeeManegement.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private  EmployeeRepository employeeRepository ;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository ;
    }

    public EmployeeResponseDto createEmployee(
            @Valid CreateEmployeeRequestDto createEmployeeRequestDto) {

        //Dto --> Entity
       Employee employee = new Employee();

        employee.setName(createEmployeeRequestDto.getName());
        employee.setEmail(createEmployeeRequestDto.getEmail());
        employee.setDepartment(createEmployeeRequestDto.getDepartment());
        employee.setDesignation(createEmployeeRequestDto.getDesignation());
        employee.setSalary(createEmployeeRequestDto.getSalary());
        employee.setPhoneNumber(createEmployeeRequestDto.getPhoneNumber());
        employee.setAge(createEmployeeRequestDto.getAge());
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());

        //Save Employee
        Employee savedEmployee = employeeRepository.save(employee);

        //Entity -->Response Dto
        EmployeeResponseDto responseDto = new EmployeeResponseDto();

        responseDto.setId(savedEmployee.getId());
        responseDto.setName(savedEmployee.getName());
        responseDto.setEmail(savedEmployee.getEmail());
        responseDto.setDepartment(savedEmployee.getDepartment());
        responseDto.setDesignation(savedEmployee.getDesignation());
        responseDto.setSalary(savedEmployee.getSalary());
        responseDto.setPhoneNumber(savedEmployee.getPhoneNumber());
        responseDto.setAge(savedEmployee.getAge());
        responseDto.setCreatedAt(savedEmployee.getCreatedAt());
        responseDto.setUpdatedAt(savedEmployee.getUpdatedAt());

        return responseDto;


    }

    public EmployeeResponseDto getEmployeeById(Long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Employee Not Found by this Id");
        }

        Employee employee = employeeOptional.get();

        EmployeeResponseDto responseDto = new EmployeeResponseDto() ;

        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setEmail(employee.getEmail());
        responseDto.setDepartment(employee.getDepartment());
        responseDto.setDesignation(employee.getDesignation());
        responseDto.setSalary(employee.getSalary());
        responseDto.setPhoneNumber(employee.getPhoneNumber());
        responseDto.setAge(employee.getAge());
        responseDto.setCreatedAt(employee.getCreatedAt());
        responseDto.setUpdatedAt(employee.getUpdatedAt());

        return responseDto;


    }

    public List<EmployeeResponseDto> findAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll() ;

        List<EmployeeResponseDto> responseDtoList = new ArrayList<>();

        for (Employee employee : employeeList){
            EmployeeResponseDto responseDto = new EmployeeResponseDto();

            responseDto.setId(employee.getId());
            responseDto.setName(employee.getName());
            responseDto.setEmail(employee.getEmail());
            responseDto.setDepartment(employee.getDepartment());
            responseDto.setDesignation(employee.getDesignation());
            responseDto.setSalary(employee.getSalary());
            responseDto.setPhoneNumber(employee.getPhoneNumber());
            responseDto.setAge(employee.getAge());
            responseDto.setCreatedAt(employee.getCreatedAt());
            responseDto.setUpdatedAt(employee.getUpdatedAt());

            responseDtoList.add(responseDto);
        }
        return responseDtoList;
    }

    public EmployeeResponseDto updateEmployeeById(
            Long id,
            UpdateEmployeeRequestDto updateEmployeeRequestDto) {

        // Find employee by ID
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Update employee fields
        employee.setName(updateEmployeeRequestDto.getName());
        employee.setEmail(updateEmployeeRequestDto.getEmail());
        employee.setDepartment(updateEmployeeRequestDto.getDepartment());
        employee.setDesignation(updateEmployeeRequestDto.getDesignation());
        employee.setSalary(updateEmployeeRequestDto.getSalary());
        employee.setPhoneNumber(updateEmployeeRequestDto.getPhoneNumber());
        employee.setAge(updateEmployeeRequestDto.getAge());
        employee.setUpdatedAt(LocalDateTime.now());

        // Save updated employee
        Employee updatedEmployee = employeeRepository.save(employee);

        // Convert Entity to Response DTO
        EmployeeResponseDto responseDto = new EmployeeResponseDto();

        responseDto.setId(updatedEmployee.getId());
        responseDto.setName(updatedEmployee.getName());
        responseDto.setEmail(updatedEmployee.getEmail());
        responseDto.setDepartment(updatedEmployee.getDepartment());
        responseDto.setDesignation(updatedEmployee.getDesignation());
        responseDto.setSalary(updatedEmployee.getSalary());
        responseDto.setPhoneNumber(updatedEmployee.getPhoneNumber());
        responseDto.setAge(updatedEmployee.getAge());
        responseDto.setCreatedAt(updatedEmployee.getCreatedAt());
        responseDto.setUpdatedAt(updatedEmployee.getUpdatedAt());

        return responseDto;
    }
}
