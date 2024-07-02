package com.guvi_mini_project_two.backend.Service.Impl;

import com.guvi_mini_project_two.backend.DTO.DoctorDto;
import com.guvi_mini_project_two.backend.DTO.RequestAppointmentDTO;
import com.guvi_mini_project_two.backend.DTO.ResponseAppointmentDTO;
import com.guvi_mini_project_two.backend.Entity.Appointment;
import com.guvi_mini_project_two.backend.Entity.Doctor;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import com.guvi_mini_project_two.backend.Model.RequestAcceptedMedicines;
import com.guvi_mini_project_two.backend.Model.ResponsePatientAppointment;
import com.guvi_mini_project_two.backend.Repository.AppointmentRepo;
import com.guvi_mini_project_two.backend.Repository.DoctorRepository;
import com.guvi_mini_project_two.backend.Service.AppointmentService;
import com.guvi_mini_project_two.backend.config.JwtAuthenticationFilter;
import com.guvi_mini_project_two.backend.user.User;
import com.guvi_mini_project_two.backend.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<ResponseAppointmentDTO> getAllDoctorAppointments(String email) {
        List<Appointment> appointmentList = appointmentRepo.findAllByDoctorEmail(email);
        List<ResponseAppointmentDTO> responseAppoinmentDTOList = new ArrayList<>();
        for(Appointment appointment : appointmentList){
            ResponseAppointmentDTO responseAppointmentDTO = new ResponseAppointmentDTO();
            modelMapper.map(appointment,responseAppointmentDTO);
            responseAppointmentDTO.setPrescriptionList(appointment.getPrescriptionList());
            responseAppoinmentDTOList.add(responseAppointmentDTO);
        }
        return responseAppoinmentDTOList;
    }

    @Override
    public List<ResponsePatientAppointment> getAllPatientAppointments(String email) {

        List<Appointment> appointmentList = appointmentRepo.findAllByPatientEmail(email);
        List<ResponsePatientAppointment> responsePatientAppointmentList = new ArrayList<>();
        for (Appointment appointment: appointmentList) {
            Doctor doctor = doctorRepository.findByEmail(appointment.getDoctorEmail());
            ResponsePatientAppointment responsePatientAppointment = new ResponsePatientAppointment();
            if (doctor != null) {
                responsePatientAppointment.setDoctorImage(doctor.getUser().getImage());
                responsePatientAppointment.setDoctorName(doctor.getUser().getName());
                responsePatientAppointment.setSpecialization(doctor.getSpecialization());
                responsePatientAppointment.setIsPrescribed(appointment.getPrescribe());
                responsePatientAppointment.setAppointmentId(appointment.getAppointmentId());
                responsePatientAppointment.setPrescriptionList(appointment.getPrescriptionList());
                responsePatientAppointmentList.add(responsePatientAppointment);
            }
        }
        return responsePatientAppointmentList;

    }

    @Override
    public void saveAppointment(RequestAppointmentDTO appointmentDto) {
        String currentUser = JwtAuthenticationFilter.CURRENT_USER;
        Optional<User> ExistingUser = userRepository.findByEmail(currentUser);
        User user = ExistingUser.get();
        SecureRandom random = new SecureRandom();
        Appointment appointment = new Appointment();
        appointment.setPatientEmail(currentUser);
        appointment.setDoctorEmail(appointmentDto.getDoctorEmail());
        appointment.setTimeSlots(appointmentDto.getTimeSlots());
        appointment.setName(user.getName());
        appointment.setGender(user.getGender());
        appointment.setPrescribe(false);
        appointment.setIsPatientConfirmed(false);
        appointment.setBookedOn(String.valueOf(LocalDate.now()));
        appointment.setAppointmentId(100000 + random.nextInt(900000));
        appointmentRepo.save(appointment);
    }

    @Override
    public void updateAppointmentByID(String id, List<PrescriptionModel> prescriptionList) {
        Appointment appointment = appointmentRepo.findByAppointmentId(Integer.parseInt(id));
        appointment.setPrescriptionList(prescriptionList);
        appointment.setPrescribe(true);
        appointmentRepo.save(appointment);
    }
    @Override
    public void updateAcceptedMedicines(RequestAcceptedMedicines request) {
        Appointment appointment = appointmentRepo.findByAppointmentId(request.getAppointmentId());
        List<PrescriptionModel> NewPrescriptionList = new ArrayList<>();
        for (PrescriptionModel pm: request.getPrescriptionList()) {
            PrescriptionModel prescriptionModel = new PrescriptionModel();
            prescriptionModel.setId(pm.getId());
            prescriptionModel.setName(pm.getName());
            prescriptionModel.setDosage(pm.getDosage());
            prescriptionModel.setQuantity(pm.getQuantity());
            prescriptionModel.setFrequency(pm.getFrequency());
            prescriptionModel.setPrice(pm.getPrice());
            NewPrescriptionList.add(prescriptionModel);
        }
        appointment.setPrescriptionList(NewPrescriptionList);
        appointment.setIsPatientConfirmed(true);
        appointmentRepo.save(appointment);
    }
}
