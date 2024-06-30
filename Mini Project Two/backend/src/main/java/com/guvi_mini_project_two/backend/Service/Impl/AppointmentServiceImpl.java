package com.guvi_mini_project_two.backend.Service.Impl;

import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Entity.Appointment;
import com.guvi_mini_project_two.backend.Repository.AppointmentRepo;
import com.guvi_mini_project_two.backend.Service.AppointmentService;
import com.guvi_mini_project_two.backend.config.JwtAuthenticationFilter;
import com.guvi_mini_project_two.backend.user.User;
import com.guvi_mini_project_two.backend.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<ResponseAppointmentDTO> getAllDoctorAppointments(String email) {
        List<Appointment> appointmentList = appointmentRepo.findAllByDoctorEmail(email);
        List<ResponseAppointmentDTO> responseAppoinmentDTOList = new ArrayList<>();
        for(Appointment appointment : appointmentList){
            ResponseAppointmentDTO responseAppoinmentDTO = new ResponseAppointmentDTO();
            modelMapper.map(appointment,responseAppoinmentDTO);
            responseAppoinmentDTOList.add(responseAppoinmentDTO);
        }
        return responseAppoinmentDTOList;
    }

    @Override
    public List<String> getAllPatientAppointments(String email) {

        return appointmentRepo.findDoctorEmailsByPatientEmail(email);

    }

    @Override
    public void saveAppointment(RequestAppointmentDTO appointmentDto) {
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        Optional<User> ExistingUser = userRepository.findByEmail(currentUser);
        User user = ExistingUser.get();
        Appointment appointment = new Appointment();
        appointment.setPatientEmail(currentUser);
        appointment.setDoctorEmail(appointmentDto.getDoctorEmail());
        appointment.setTimeSlots(appointmentDto.getTimeSlots());
        appointment.setName(user.getName());
        appointment.setGender(user.getGender());
        appointment.setPrescribe(false);
        appointment.setBookedOn(String.valueOf(LocalDate.now()));
        appointment.setStatus(false);
        appointmentRepo.save(appointment);
    }
}
