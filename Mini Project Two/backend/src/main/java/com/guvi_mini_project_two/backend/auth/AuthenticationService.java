package com.guvi_mini_project_two.backend.auth;

import com.guvi_mini_project_two.backend.Entity.Doctor;
import com.guvi_mini_project_two.backend.Repository.DoctorRepository;
import com.guvi_mini_project_two.backend.config.JwtService;
import com.guvi_mini_project_two.backend.user.Role;
import com.guvi_mini_project_two.backend.user.User;
import com.guvi_mini_project_two.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request, MultipartFile image) throws IOException {

        var user = User.builder()
                .username(request.getFullname())
                .email(request.getEmail())
                .name(request.getFullname())
                .password(passwordEncoder.encode(request.getPassword()))
                .gender(request.getGender())
                .image(Base64.getEncoder().encodeToString(image.getBytes()))
                .roles(Set.of(Role.valueOf(request.getRole())))
                .build();

        if(Objects.equals(request.getRole(), "DOCTOR")){
            Doctor doctor = new Doctor();
            doctor.setUser(user);
            doctor.setEmail(user.getEmail());
            doctor.setVerified(false);
            doctorRepository.save(doctor);
        }
        repository.save(user);

        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        Set<Role> role = user.getRoles();
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(role)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        Set<Role> role = user.getRoles();
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(role)
                .build();
    }

}
