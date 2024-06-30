package com.guvi_mini_project_two.backend.Repository;

import com.guvi_mini_project_two.backend.Entity.Appointment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends MongoRepository<Appointment, ObjectId> {

    List<Appointment> findAllByDoctorEmail(String email);
    List<Appointment> findAllByPatientEmail(String email);

    @Query(value = "{ 'patientEmail': ?0 }", fields = "{ 'doctorEmail': 1, '_id': 0 }")
    List<String> findDoctorEmailsByPatientEmail(String patientEmail);
}
