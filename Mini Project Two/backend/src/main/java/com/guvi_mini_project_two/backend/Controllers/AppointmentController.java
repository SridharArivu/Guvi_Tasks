package com.guvi_mini_project_two.backend.Controllers;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Service.Impl.AppointmentServiceImpl;
import com.guvi_mini_project_two.backend.config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/save")
    public ResponseEntity<Void> storeAppointment(@RequestBody RequestAppointmentDTO appointmentDto) {

        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all/doctor/appointments")
    public ResponseEntity<List<ResponseAppointmentDTO>> AllDoctorAppoints(){
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        return new ResponseEntity<>(appointmentService.getAllDoctorAppointments(currentUser),HttpStatus.OK);
    }

    @GetMapping("/all/patient/appointments")
    public List<String> AllPatientAppoints(){
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        return appointmentService.getAllPatientAppointments(currentUser);
    }

}
