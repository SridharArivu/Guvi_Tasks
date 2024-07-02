package com.guvi_mini_project_two.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentUpdateRequest {
    private String id;
    private List<PrescriptionModel> prescriptionList;

}
