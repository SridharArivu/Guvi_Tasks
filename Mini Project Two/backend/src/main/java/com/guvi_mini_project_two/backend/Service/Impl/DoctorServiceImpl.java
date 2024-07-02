package com.guvi_mini_project_two.backend.Service.Impl;

import com.guvi_mini_project_two.backend.DTO.DoctorDto;
import com.guvi_mini_project_two.backend.Entity.Doctor;
import com.guvi_mini_project_two.backend.Repository.DoctorRepository;
import com.guvi_mini_project_two.backend.Service.DoctorService;
import com.guvi_mini_project_two.backend.auth.RegisterRequest;
import com.guvi_mini_project_two.backend.user.User;
import com.guvi_mini_project_two.backend.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.*;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DoctorDto getDoctor(String email) {

        Doctor doctor = doctorRepository.findByEmail(email);
        Optional<User> user = userRepository.findByEmail(email);
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setUsername(doctor.getUser().getName());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setRoles(doctor.getUser().getRoles());
        doctorDto.setGender(doctor.getUser().getGender());
        doctorDto.setPhoneNumber(doctor.getPhoneNumber());
        doctorDto.setSpecialization(doctor.getSpecialization() != null ? doctor.getSpecialization() : null);
        doctorDto.setFees(doctor.getFees() != null ? doctor.getFees() : null);
        doctorDto.setTimeSlots(doctor.getTimeSlotsList() != null ? doctor.getTimeSlotsList() : null);
        doctorDto.setVerified(doctor.getVerified());
        doctorDto.setImage(doctor.getUser().getImage());
        return doctorDto;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();

        for(Doctor doctor : doctors){
            if(!doctor.getVerified()) continue;
            DoctorDto doctorDto =  new DoctorDto();
            doctorDto.setUsername(doctor.getUser().getName());
            doctorDto.setEmail(doctor.getEmail());
            doctorDto.setImage(doctor.getUser().getImage());
            doctorDto.setSpecialization(doctor.getSpecialization());
            doctorDto.setFees(doctor.getFees());
            doctorDto.setTimeSlots(doctor.getTimeSlotsList());
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }


    @Override
    public Doctor updateDoctorDetails(DoctorDto request, MultipartFile file) throws IOException {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            User userObj = userOpt.get();

            userObj.setEmail(request.getEmail());
            userObj.setUsername(request.getUsername());
            if (file != null && !file.isEmpty()) {
                userObj.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            }
            userObj.setName(request.getUsername());
            userRepository.save(userObj);

            Doctor doctor = doctorRepository.findByEmail(request.getEmail());
            doctorRepository.deleteByEmail(request.getEmail());
            if (doctor != null) {
                doctor.setUser(userObj);
                doctor.setVerified(true);
                doctor.setSpecialization(request.getSpecialization());
                doctor.setTimeSlotsList(request.getTimeSlots());
                doctor.setFees(request.getFees());
                doctor.setPhoneNumber(request.getPhoneNumber());
                return doctorRepository.save(doctor);
            }
        }
        return null; // or throw an exception if the doctor is not found
    }


}
