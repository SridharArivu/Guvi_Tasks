package com.guvi_mini_project_two.backend.Service;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Entity.Appointment;

import java.util.List;

public interface AppointmentService {

    List<ResponseAppointmentDTO> getAllDoctorAppointments(String email);
    List<String> getAllPatientAppointments(String email);

    void saveAppointment(RequestAppointmentDTO appointmentDto);
}
