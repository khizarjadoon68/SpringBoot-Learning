package com.LearningSpringBoot.LearningRestAPIs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.LearningSpringBoot.LearningRestAPIs.Entity.Student ;
import org.springframework.stereotype.Repository;

// This interface is for to connect Controller and Entity .
//It is used for the Query of Entities .
@Repository
/*@Repository marks a class as a Data Access Layer. It is responsible
 for interacting with the database and performing CRUD operations.
 */
public interface StudentRepository extends JpaRepository <Student,Long> {

}
