package com.example.EmployeeManegement.controller;

import com.example.EmployeeManegement.dto.CreateEmployeeRequestDto;
import com.example.EmployeeManegement.dto.EmployeeResponseDto;
import com.example.EmployeeManegement.dto.UpdateEmployeeRequestDto;
import com.example.EmployeeManegement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService =employeeService ;
    }

    @PostMapping ("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee (
            @Valid
            @RequestBody CreateEmployeeRequestDto createEmployeeRequestDto ){

       EmployeeResponseDto employeeResponseDto =employeeService.createEmployee(createEmployeeRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeResponseDto) ;

    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee (@PathVariable Long id){

        EmployeeResponseDto responseDto = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(responseDto) ;
    }

    @GetMapping("/get/allEmployees")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee (){

       List<EmployeeResponseDto> responseDto = employeeService.findAllEmployees();

       return ResponseEntity.ok(responseDto);

    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @RequestBody UpdateEmployeeRequestDto updateEmployeeRequestDto ,
            @PathVariable Long id){

       EmployeeResponseDto responseDto = employeeService.updateEmployeeById(id ,updateEmployeeRequestDto);

       return ResponseEntity.ok(responseDto);

    }








}
