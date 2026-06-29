package com.LearningSpringBoot.LearningRestAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
/*It is a Lombok annotation that automatically generates getters, setters, toString(), equals(),
 and a required-arguments constructor for a class at compile time.
 */
//Lombok is a Dependency add from Spring initializer .

@AllArgsConstructor
// It automatically creates a Constructor with all arguments
public class StudentDto {
    private long id;
    private String name;
    private String email;

}
