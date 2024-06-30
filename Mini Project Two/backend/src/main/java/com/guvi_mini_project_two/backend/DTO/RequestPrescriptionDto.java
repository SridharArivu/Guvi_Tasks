package com.guvi_mini_project_two.backend.DTO;

import com.guvi_mini_project_two.backend.Entity.Prescription;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPrescriptionDto {
    private String doctorEmail;
    private String patientEmail;
    private String patientName;
    private List<PrescriptionModel> prescriptionList;
    private boolean isPatientConfirmed;
}
