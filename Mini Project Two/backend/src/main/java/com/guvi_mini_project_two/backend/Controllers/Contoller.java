package com.guvi_mini_project_two.backend.Controllers;

import com.guvi_mini_project_two.backend.DTO.UserResponseDto;
import com.guvi_mini_project_two.backend.config.JwtAuthenticationFilter;
import com.guvi_mini_project_two.backend.user.User;
import com.guvi_mini_project_two.backend.user.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class Contoller {

    @Autowired
    private UserRepository userRepository;

    //return user Details
    @GetMapping("/get/profile")
    public ResponseEntity<UserResponseDto> getUserProfilePic(){
        String CurrentUser = JwtAuthenticationFilter.CURRENT_USER;
        Optional<User> u = userRepository.findByEmail(CurrentUser);
        User user = u.get();
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setProfilePicture(user.getImage());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        return ResponseEntity.ok(userResponse);
    }

    // Ping Controller Just to Check if server is running
    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("Server running..");
    }
}
