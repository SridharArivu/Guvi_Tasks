package com.guvi.mini_project_one_backend.repository;

import com.guvi.mini_project_one_backend.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

        Employee findByEmployeeID(String id) ;
        void deleteByEmployeeID(String id);
        boolean existsByEmployeeID(String id);
}
