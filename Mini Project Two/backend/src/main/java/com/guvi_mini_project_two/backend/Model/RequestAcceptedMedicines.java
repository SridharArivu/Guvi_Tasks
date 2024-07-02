package com.guvi_mini_project_two.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAcceptedMedicines {
    private Integer appointmentId;
    private List<PrescriptionModel> prescriptionList;

    @Override
    public String toString() {
        return "RequestAcceptedMedicines{" +
                "appointmentId=" + appointmentId +
                ", prescriptionList=" + prescriptionList +
                '}';
    }
}
