package com.guvi.day22.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
    @Id
    private ObjectId id;

    private String employeeID;
    private String firstName;
    private String lastName;
    private String role;
    private String color;
    private String gender;
    private String email;
    private Long phone;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private Integer zipCode;
    private String image;
}
