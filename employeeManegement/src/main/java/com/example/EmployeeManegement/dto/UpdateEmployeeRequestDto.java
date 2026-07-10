package com.example.EmployeeManegement.dto;

import jakarta.validation.constraints.*;

public class UpdateEmployeeRequestDto {

    @NotBlank
    private String name ;

    @Email
    @NotBlank
    private String email ;

    @NotBlank
    private String department ;

    @NotBlank
    private String designation ;

    @Positive
    private double salary ;

    @Pattern(regexp = "^[0-9]{11}$")
    private String phoneNumber ;

    @Min(18) @Max(60)
    private Integer age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
