package com.guvi_mini_project_two.backend.DTO;

import com.guvi_mini_project_two.backend.user.Role;
import com.guvi_mini_project_two.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String username;
    private String email;
    private Set<Role> roles;
    private String gender;
    private String image;
    private Long phoneNumber;
    private String specialization;
    private Integer fees;
    private List<TimeSlots> timeSlots;
    private Boolean verified;
}
