package com.guvi_mini_project_two.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestAppointmentDTO {

    private String doctorEmail;
    private String timeSlots;

    @Override
    public String toString() {
        return "AppointmentDto{" +
                "doctorEmail='" + doctorEmail + '\'' +
                ", timeSlots='" + timeSlots + '\'' +
                '}';
    }
}
