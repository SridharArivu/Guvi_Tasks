package com.guvi_mini_project_two.backend.Model;

import com.guvi_mini_project_two.backend.DTO.AppointmentDto;
import com.guvi_mini_project_two.backend.DTO.DoctorDto;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePatientAppointment {

    private String doctorImage;
    private String doctorName;
    private String specialization;
    private Boolean isPrescribed;
    private Integer appointmentId;
    private List<PrescriptionModel> prescriptionList;
}
