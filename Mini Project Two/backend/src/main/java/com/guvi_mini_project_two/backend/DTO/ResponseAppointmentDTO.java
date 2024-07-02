package com.guvi_mini_project_two.backend.DTO;

import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAppointmentDTO {


    private String name;
    private String gender;
    private String doctorEmail;
    private String patientEmail;
    private Boolean prescribe;
    private String bookedOn;
    private String timeSlots;
    private Boolean isPatientConfirmed;
    private Integer appointmentId;
    private List<PrescriptionModel> prescriptionList;
}
