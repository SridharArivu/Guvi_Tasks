package com.guvi.day22.controller;

import com.guvi.day22.entity.Employee;
import com.guvi.day22.service.Impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag( name = "Display-By-ID Controller", description = "returns All Employee by ID" )
public class DisplayById {
    @Autowired
    private EmployeeServiceImpl employeeService;

    // returns employee by ID using Search Input
    @PostMapping("/display-by-id")
    public String postEmployeeId(@RequestParam("search") String search){
        return "redirect:/display/" + search;
    }
    // returns employee by ID in employeeDetails HTML Page
    @GetMapping("/display/{id}")
    public String EmployeeById(@PathVariable String id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employeeDetails";
        }else return "redirect:/display/All";
    }
}
