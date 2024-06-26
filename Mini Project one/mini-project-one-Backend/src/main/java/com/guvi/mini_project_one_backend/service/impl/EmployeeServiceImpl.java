package com.guvi.mini_project_one_backend.service.impl;

import com.guvi.mini_project_one_backend.DTO.EmployeeDto;
import com.guvi.mini_project_one_backend.entity.Employee;
import com.guvi.mini_project_one_backend.repository.EmployeeRepository;
import com.guvi.mini_project_one_backend.service.EmployeeService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Employee storeEmployeeDetails(Employee employee, MultipartFile file) throws IOException {
        employee.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto getEmployeeById(String id) {
        Employee employee = employeeRepository.findByEmployeeID(id);

        return modelMapper.map(employee,EmployeeDto.class);

    }

    @Override
    public EmployeeDto updateEmployee(String id, Employee employee) {
        Employee existingEmployee = employeeRepository.findByEmployeeID(id);
        if (existingEmployee != null) {

            ObjectId existingId = existingEmployee.getId();
            modelMapper.map(employee, existingEmployee);
            existingEmployee.setId(existingId);

            return  modelMapper.map(employeeRepository.save(existingEmployee),EmployeeDto.class);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(String id) {

        if(employeeRepository.existsByEmployeeID(id)){
            employeeRepository.deleteByEmployeeID(id);
            return true;
        }else return false;

    }
}

