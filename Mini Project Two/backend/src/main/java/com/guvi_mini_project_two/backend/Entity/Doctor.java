package com.guvi_mini_project_two.backend.Entity;

import com.guvi_mini_project_two.backend.DTO.TimeSlots;
import com.guvi_mini_project_two.backend.user.Role;
import com.guvi_mini_project_two.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private User user;
    private Long phoneNumber;
    private String email;
    private String specialization;
    private Integer fees;
    private List<TimeSlots> timeSlotsList;
    private Boolean verified;
}
