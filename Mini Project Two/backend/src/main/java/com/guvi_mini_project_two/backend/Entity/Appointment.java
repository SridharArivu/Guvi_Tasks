package com.guvi_mini_project_two.backend.Entity;

import com.guvi_mini_project_two.backend.DTO.TimeSlots;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private Boolean prescribe;
    private String bookedOn;
    private String timeSlots;
    private Integer appointmentId;
    private Boolean isPatientConfirmed;
    private List<PrescriptionModel> prescriptionList;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", prescribe=" + prescribe +
                ", bookedOn='" + bookedOn + '\'' +
                ", timeSlots='" + timeSlots + '\'' +
                ", appointmentId=" + appointmentId +
                ", isPatientConfirmed=" + isPatientConfirmed +
                ", prescriptionList=" + prescriptionList +
                '}';
    }
}
