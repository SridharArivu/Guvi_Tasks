package com.guvi_mini_project_two.backend.Entity;


import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "prescription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    private ObjectId id;
    private String patientEmail;
    private String patientName;
    private String doctorEmail;
    private List<PrescriptionModel> prescriptionList;
    private Boolean isPatientConfirmed;

}
