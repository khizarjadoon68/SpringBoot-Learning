package com.LearningSpringBoot.LearningRestAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*It is a Lombok annotation that automatically generates getters, setters, toString(), equals(),
 and a required-arguments constructor for a class at compile time.
 */
//Lombok is a Dependency add from Spring initializer .

@AllArgsConstructor
// It automatically creates a Constructor with all arguments
@NoArgsConstructor
//It automatically generates a No-args(default) Constructor for your class at compile time .
public class StudentDto {
    private long id;
    private String name;
    private String email;

}
