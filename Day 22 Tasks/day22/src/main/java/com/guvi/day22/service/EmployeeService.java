package com.guvi.day22.service;

import com.guvi.day22.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();


    public Employee getEmployeeById(String id);

}
