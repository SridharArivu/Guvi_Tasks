package com.guvi_mini_project_two.backend.Repository;

import com.guvi_mini_project_two.backend.Entity.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, ObjectId> {

    Doctor findByEmail(String email);

    void deleteByEmail(String email);
}
