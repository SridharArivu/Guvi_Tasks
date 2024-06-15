package com.guvi.day22.controller;

import com.guvi.day22.entity.Employee;
import com.guvi.day22.service.Impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
@RequestMapping("/")
@Tag( name = "Home Controller", description = "To add new Employee" )
public class HomeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    // Maps Employee Object to add Employee Form
    @GetMapping()
    public String home(Model model){
        model.addAttribute("employee", new Employee());
        return "home";
    }
    // Adds a new employee to the database
    // Returns to 'display all' employees in the table
    @PostMapping("addEmployee")
    public String addEmployee(Model model, Employee employee, @RequestParam("file") MultipartFile file) throws IOException {
        employeeService.saveEmployee(employee,file);
        return "redirect:/display/all";
    }
}
