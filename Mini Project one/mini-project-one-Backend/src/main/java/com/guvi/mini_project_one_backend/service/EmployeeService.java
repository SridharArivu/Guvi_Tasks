package com.guvi.mini_project_one_backend.service;

import com.guvi.mini_project_one_backend.DTO.EmployeeDto;
import com.guvi.mini_project_one_backend.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    public Employee storeEmployeeDetails(Employee employee, MultipartFile file) throws IOException;

    List<Employee> getAllEmployee();

    EmployeeDto getEmployeeById(String id);

    EmployeeDto updateEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);
}
