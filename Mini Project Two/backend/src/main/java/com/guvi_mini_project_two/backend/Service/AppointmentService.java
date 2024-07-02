package com.guvi_mini_project_two.backend.Service;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Entity.Appointment;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import com.guvi_mini_project_two.backend.Model.RequestAcceptedMedicines;
import com.guvi_mini_project_two.backend.Model.ResponsePatientAppointment;

import java.util.List;

public interface AppointmentService {

    List<ResponseAppointmentDTO> getAllDoctorAppointments(String email);
    List<ResponsePatientAppointment> getAllPatientAppointments(String email);

    void saveAppointment(RequestAppointmentDTO appointmentDto);

    void updateAppointmentByID(String id, List<PrescriptionModel> prescriptionList);

    void updateAcceptedMedicines(RequestAcceptedMedicines request);
}
