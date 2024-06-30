package com.guvi_mini_project_two.backend.Controllers;

import com.guvi_mini_project_two.backend.DTO.DoctorDto;
import com.guvi_mini_project_two.backend.Entity.Doctor;
import com.guvi_mini_project_two.backend.Service.Impl.DoctorServiceImpl;
import com.guvi_mini_project_two.backend.auth.RegisterRequest;
import com.guvi_mini_project_two.backend.config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping()
    public ResponseEntity<DoctorDto> doctorByid(){
        String CurrentUser = JwtAuthenticationFilter.CURRENT_USER;
        return Optional.ofNullable(doctorService.getDoctor(CurrentUser))
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorDto>> allDoctors(){
        List<DoctorDto> doctorDtoList = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctorDtoList,HttpStatus.OK);
    }

    @PutMapping("/update-doctor-includes-image")
    public ResponseEntity<DoctorDto> updateDoctorWithImage(@RequestPart("image") MultipartFile file,
                                                  @RequestPart("user") DoctorDto request) throws IOException {

        String CurrentUser = JwtAuthenticationFilter.CURRENT_USER;

        Doctor doctor = doctorService.updateDoctorDetailsWithImage(request,file);
        if(doctor != null){
            return ResponseEntity.ok(doctorService.getDoctor(CurrentUser));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update-doctor")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestPart("user") DoctorDto request){
        String CurrentUser = JwtAuthenticationFilter.CURRENT_USER;

        Doctor doctor = doctorService.updateDoctorDetails(request);
        if(doctor != null){
            return ResponseEntity.ok(doctorService.getDoctor(CurrentUser));
        }
        return ResponseEntity.notFound().build();
    }
}
