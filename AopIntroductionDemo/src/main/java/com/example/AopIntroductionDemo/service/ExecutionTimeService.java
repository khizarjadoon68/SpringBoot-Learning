package com.example.AopIntroductionDemo.service;

import com.example.AopIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{

    private LoggingDecorator loggingDecorator ;

    public ExecutionTimeService (LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator ;
    }

    @Override
    public void createStudent(Student student) {

        Long start = System.currentTimeMillis();

        loggingDecorator.createStudent(student);
        Long end = System.currentTimeMillis();

        Long duration = end - start ;
        System.out.println("Total Duration "+duration);
    }
}
