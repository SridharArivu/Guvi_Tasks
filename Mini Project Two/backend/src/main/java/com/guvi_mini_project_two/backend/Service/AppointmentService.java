package com.guvi_mini_project_two.backend.Service;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Entity.Appointment;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import com.guvi_mini_project_two.backend.Model.RequestAcceptedMedicines;
import com.guvi_mini_project_two.backend.Model.ResponsePatientAppointment;

import java.util.List;

public interface AppointmentService {

    // Retrieve all the Appointments Created for Doctor ( find by Email )
    List<ResponseAppointmentDTO> getAllDoctorAppointments(String email);


    // Retrieve all the Appointments Created by Patients ( find by Email )
    List<ResponsePatientAppointment> getAllPatientAppointments(String email);


    // Stores Appointment Details request from Patients
    void saveAppointment(RequestAppointmentDTO appointmentDto);


    // Doctors can update their appointments by prescribing Medicines
    void updateAppointmentByID(String id, List<PrescriptionModel> prescriptionList);


    // Patients can View/Edit or Remove Medicines Prescribed by Doctor
    void updateAcceptedMedicines(RequestAcceptedMedicines request);
}
