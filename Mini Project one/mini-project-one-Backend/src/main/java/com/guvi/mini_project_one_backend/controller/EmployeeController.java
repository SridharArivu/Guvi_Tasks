package com.guvi.mini_project_one_backend.controller;

import com.guvi.mini_project_one_backend.DTO.EmployeeDto;
import com.guvi.mini_project_one_backend.Documentation.EmployeeControllerApi;
import com.guvi.mini_project_one_backend.entity.Employee;
import com.guvi.mini_project_one_backend.service.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController implements EmployeeControllerApi {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Override
    @PostMapping("/v1/save-emp-details")
    public ResponseEntity<String> saveEmployee(@RequestPart("image") MultipartFile file,
                                         @RequestPart("employee") Employee employee){
        try{
            Employee employeeObj = employeeService.storeEmployeeDetails(employee,file);
            return new ResponseEntity<>("Employee details saved successfully", HttpStatus.OK);
        }catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save employee details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping("/v1/get-all-employee")
    public ResponseEntity<List<Employee>> allEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @Override
    @GetMapping("/v1/emp-by-id/{employeeID}")
    public ResponseEntity<EmployeeDto> EmployeeById(@PathVariable String employeeID){

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeID);
        if(employeeDto != null){
            return new ResponseEntity<>(employeeDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PutMapping("/v1/update-emp/{employeeID}")
    public ResponseEntity<String> UpdateEmployeeById(@PathVariable String employeeID,@RequestBody Employee employee){
        EmployeeDto emp = employeeService.updateEmployee(employeeID,employee);

        if(emp != null){
            return new ResponseEntity<>("SuccessFully Updated",HttpStatus.OK);
        }
         return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping("/v1/delete-emp/{employeeID}")
    public ResponseEntity<String> DeleteEmployeeById(@PathVariable String employeeID){
        if(employeeService.deleteEmployee(employeeID)){
            return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
