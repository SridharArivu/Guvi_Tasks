package com.guvi_mini_project_two.backend.Service.Impl;

import com.guvi_mini_project_two.backend.DTO.RequestPrescriptionDto;
import com.guvi_mini_project_two.backend.Entity.Prescription;
import com.guvi_mini_project_two.backend.Model.PrescriptionModel;
import com.guvi_mini_project_two.backend.Repository.PrescriptionRepo;
import com.guvi_mini_project_two.backend.Service.PrescriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepo prescriptionRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void savePrescription(RequestPrescriptionDto request) {
        Prescription prescription = new Prescription();
        modelMapper.map(request,prescription);
        prescriptionRepo.save(prescription);
    }
}
