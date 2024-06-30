package com.guvi_mini_project_two.backend.Repository;

import com.guvi_mini_project_two.backend.Entity.Prescription;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends MongoRepository<Prescription, ObjectId> {
}
