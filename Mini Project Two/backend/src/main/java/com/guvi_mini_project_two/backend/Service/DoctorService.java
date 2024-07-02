package com.guvi_mini_project_two.backend.Service;

import com.guvi_mini_project_two.backend.DTO.DoctorDto;
import com.guvi_mini_project_two.backend.Entity.Doctor;
import com.guvi_mini_project_two.backend.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {

    public DoctorDto getDoctor(String email);

    Doctor updateDoctorDetails(DoctorDto request, MultipartFile file) throws IOException;

   List<DoctorDto> getAllDoctors();
}
