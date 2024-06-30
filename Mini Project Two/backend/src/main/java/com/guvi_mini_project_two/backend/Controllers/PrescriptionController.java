package com.guvi_mini_project_two.backend.Controllers;

import com.guvi_mini_project_two.backend.DTO.RequestPrescriptionDto;
import com.guvi_mini_project_two.backend.DTO.ResPrescriptionDto;
import com.guvi_mini_project_two.backend.Service.Impl.PrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionServiceImpl prescriptionService;

    @PostMapping("/save")
    public ResponseEntity<Void> storePrescription(@RequestBody RequestPrescriptionDto request) {
        prescriptionService.savePrescription(request);
        return ResponseEntity.ok().build();
    }

}
