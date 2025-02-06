package org.example.rest.controller;

import lombok.AllArgsConstructor;
import org.example.DTO.EmployeeDTO.EmployeeDTORequest;
import org.example.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.example.exception.NotFoundInDatabaseException;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDTOResponse create(@RequestBody EmployeeDTORequest employeeDTORequest) {
        return employeeService.create(employeeDTORequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id) throws NotFoundInDatabaseException {
        employeeService.deleteById(id);
    }

    @GetMapping("/{id}")
    EmployeeDTOResponse findById(@PathVariable Long id) throws NotFoundInDatabaseException {
        return employeeService.findById(id);
    }
}
