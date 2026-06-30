package com.LearningSpringBoot.LearningRestAPIs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*@Entity : It marks a Java class as a database entity. It tells Spring Boot
  that this class should be mapped to a table in the database.
 */
@Entity
@Getter
@Setter
//These getter and setter we use to access these private variables.
public class Student {

// @ID : It marks a field as the Primary Key of an entity.
    @Id
// @GeneratedValue : It automatically generate the value of the primary key (@Id).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name ;

    private String email ;
}
