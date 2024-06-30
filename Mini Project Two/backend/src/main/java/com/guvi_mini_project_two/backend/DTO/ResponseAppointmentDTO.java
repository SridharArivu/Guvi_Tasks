package com.guvi_mini_project_two.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAppointmentDTO {


    private String name;
    private String gender;
    private Boolean status;
    private String doctorEmail;
    private String patientEmail;
    private Boolean prescribe;
    private String bookedOn;
    private String timeSlots;
}
