package com.guvi_mini_project_two.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionModel {
    private Integer id;
    private String name;
    private String dosage;
    private String frequency;
    private Integer quantity;
    private Integer price;
}
