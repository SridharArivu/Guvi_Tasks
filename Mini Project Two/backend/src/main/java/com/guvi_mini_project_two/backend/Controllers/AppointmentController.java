package com.guvi_mini_project_two.backend.Controllers;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Model.AppointmentUpdateRequest;
import com.guvi_mini_project_two.backend.Model.RequestAcceptedMedicines;
import com.guvi_mini_project_two.backend.Model.ResponsePatientAppointment;
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


    // Stores Appointment Details request from Patients
    @PostMapping("/save")
    public ResponseEntity<Void> storeAppointment(@RequestBody RequestAppointmentDTO appointmentDto) {

        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Retrieve all the Appointments Created for Doctor ( find by Email )
    @GetMapping("/all/doctor/appointments")
    public ResponseEntity<List<ResponseAppointmentDTO>> AllDoctorAppoints(){
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        return new ResponseEntity<>(appointmentService.getAllDoctorAppointments(currentUser),HttpStatus.OK);
    }

    // Retrieve all the Appointments Created by Patients ( find by Email )
    @GetMapping("/all/patient/appointments")
    public List<ResponsePatientAppointment> AllPatientAppoints(){
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        return appointmentService.getAllPatientAppointments(currentUser);
    }

    // Doctors can update their appointments by prescribing Medicines
    @PutMapping("/update/appointment")
    public ResponseEntity<Void> updateAppointment(
            @RequestBody AppointmentUpdateRequest request) {
        appointmentService.updateAppointmentByID(request.getId(), request.getPrescriptionList());
        return ResponseEntity.ok().build();
    }

    // Patients can View/Edit or Remove Medicines Prescribed by Doctor
    @PutMapping("/accepted/medicines")
    public ResponseEntity<Object> acceptFromPatient(@RequestBody RequestAcceptedMedicines request){
        appointmentService.updateAcceptedMedicines(request);
        System.out.println(request);
        return ResponseEntity.ok().build();
    }
}
