package in.strikes.crudSpringBoot.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentRequestDto {

    @NotBlank(message = "name can not be Null Empty , Blank-Spaces .")
    private String name;

    @NotNull (message = "Age must be Required .")
    @Min(value = 18 ,message = "Student Age Must be greater then 18Years .")
    private int age;

    @NotBlank(message = "Email must be Required .")
    @Email (message ="Student Email must be valid ." )
    private String email;
    private int rollNo;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
