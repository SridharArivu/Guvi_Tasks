package com.guvi.mini_project_one_backend.Documentation;

import com.guvi.mini_project_one_backend.DTO.EmployeeDto;
import com.guvi.mini_project_one_backend.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeControllerApi {

    @Operation(
            summary = "Create new Employee",
            description = "Stores New Employee information",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Employee object that needs to be updated",
                    required = true
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Employee details saved successfully",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = {
                                            @ExampleObject(
                                                    value = "Employee details saved successfully"
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Failed to save employee details",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = {
                                            @ExampleObject(
                                                    value = "Failed to save employee details due to server error"
                                            )
                                    }
                            )
                    )
            }
    )
    ResponseEntity<String> saveEmployee(@RequestPart("image") MultipartFile file,
                                        @RequestPart("employee") Employee employee);


    @Operation(
            summary = "Get All Employees",
            description = "Retrieve a list of all employees",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved list",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Employee.class),
                                    examples = @ExampleObject(
                                            value = "[{ \"employeeId\": \"2372728\",\"firstName\": \"John\", \"lastName\": \"Doe\", \"role\": \"Software Developer\", \"gender\": \"Male\", \"email\": \"john.doe@example.com\", \"phone\": \"1234567890\", \"streetAddress\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"Anystate\", \"country\": \"Anycountry\", \"pincode\": \"123456\", \"image\": \"byteCode\" }]"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "No employees found",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "No employees found"
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<List<Employee>> allEmployee();


    @Operation(
            summary = "Get Employee by ID",
            description = "Retrieve an employee by their ID",
            parameters = {
                    @Parameter(
                            name = "employeeID",
                            description = "The ID of the employee to retrieve",
                            required = true,
                            schema = @Schema(type = "string"),
                            examples = @ExampleObject(
                                    value = "2877233"
                            )
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved employee",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeDto.class),
                                    examples = @ExampleObject(
                                            value = "{ \"employeeId\": \"2372728\",\"firstName\": \"John\", \"lastName\": \"Doe\", \"role\": \"Software Developer\", \"gender\": \"Male\", \"email\": \"john.doe@example.com\", \"phone\": \"1234567890\", \"streetAddress\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"Anystate\", \"country\": \"Anycountry\", \"pincode\": \"123456\", \"image\": \"byteCode\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Employee not found",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "Employee not found"
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<EmployeeDto> EmployeeById(@PathVariable String employeeID);

    @Operation(
            summary = "Update Employee by ID",
            description = "Update an employee's details by their ID",
            parameters = {
                    @Parameter(
                            name = "employeeID",
                            description = "The ID of the employee to update",
                            required = true,
                            schema = @Schema(type = "string"),
                            examples = @ExampleObject(
                                    value = "2877233"
                            )
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Employee object that needs to be updated",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class),
                            examples = @ExampleObject(
                                    value = "{ \"employeeId\": \"2877233\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"role\": \"Software Developer\", \"gender\": \"Male\", \"email\": \"john.doe@example.com\", \"phone\": \"1234567890\", \"streetAddress\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"Anystate\", \"country\": \"Anycountry\", \"pincode\": \"123456\" }"
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated employee",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "Successfully Updated"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Employee not found",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "Employee Not Found"
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<String> UpdateEmployeeById(
            @PathVariable String employeeID,
            @RequestBody Employee employee);

    @Operation(
            summary = "Delete Employee by ID",
            description = "Delete an employee by their ID",
            parameters = {
                    @Parameter(
                            name = "employeeID",
                            description = "The ID of the employee to delete",
                            required = true,
                            schema = @Schema(type = "string"),
                            examples = @ExampleObject(
                                    value = "2877233"
                            )
                    )
            },

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Employee deleted successfully",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "Employee Deleted Successfully"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Employee not found",
                            content = @Content(
                                    mediaType = "text/plain",
                                    examples = @ExampleObject(
                                            value = "Employee Not Found"
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<String> DeleteEmployeeById(@PathVariable String employeeID);
}
