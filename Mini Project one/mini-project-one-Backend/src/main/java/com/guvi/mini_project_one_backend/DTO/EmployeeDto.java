package com.guvi.mini_project_one_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    public String employeeID;
    public String firstName;
    public String lastName;
    public String role;
    public String gender;
    public String email;
    public Long phone;
    public String streetAddress;
    public String city;
    public String state;
    public String country;
    public Integer pincode;
    public String image;
}
