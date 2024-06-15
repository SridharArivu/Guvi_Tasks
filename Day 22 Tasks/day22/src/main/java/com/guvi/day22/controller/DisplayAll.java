package com.guvi.day22.controller;

import com.guvi.day22.entity.Employee;
import com.guvi.day22.service.Impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/display")
@Tag( name = "Display-All Controller", description = "returns All Employees details")
public class DisplayAll {

    @Autowired
    private EmployeeServiceImpl employeeService;

    // returns all Employee details in displayAll HTML Page
    @GetMapping("/all")
    public String DisplayAllEmployees(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeListSize", employeeList.size());
        return "displayAll";
    }
}
