package in.strikes.crudSpringBoot.repository;

import in.strikes.crudSpringBoot.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public Student saveStudent(Student studentReq) {
        //Save to db
        System.out.println("Inside Student Repository");
        System.out.println("Exiting Student Repository");

        Student s1 = new Student();
        s1.setName("Khizar Ali");
        s1.setAge(23);
        s1.setEmail("khizar@gmail.com");
        s1.setRollNo(101);
        s1.setSubject("Spring FrameWork");

        return s1 ;
    }
}
