package com.guvi_mini_project_two.backend.Entity;

import com.guvi_mini_project_two.backend.DTO.TimeSlots;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {

    @Id
    private ObjectId id;

    private String doctorEmail;

    private String patientEmail;

    private String name;
    private String gender;
    private Boolean status;
    private Boolean prescribe;
    private String bookedOn;
    private String timeSlots;

}
