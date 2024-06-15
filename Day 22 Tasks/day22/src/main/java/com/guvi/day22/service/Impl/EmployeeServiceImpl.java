package com.guvi.day22.service.Impl;

import com.guvi.day22.entity.Employee;
import com.guvi.day22.repository.EmployeeRepository;
import com.guvi.day22.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
       return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findByEmployeeID(id);
    }



    public void saveEmployee(Employee employee, MultipartFile file) throws IOException {
        String[] colors = {"#9fc1ff","#ffd7ae","#ff97a3","#73ffd6","#a4d0e7"};
        String[] roles = {"UI/UX Designer","Software Engineer","Product Manager","Data Scientist","System Administrator"};
        employee.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        employee.setColor(colors[Integer.parseInt(employee.getRole())]);
        employee.setRole(roles[Integer.parseInt(employee.getRole())]);
        employeeRepository.save(employee);
    }

}
