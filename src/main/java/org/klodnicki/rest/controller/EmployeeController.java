package org.klodnicki.rest.controller;

import lombok.AllArgsConstructor;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTORequest;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.klodnicki.exception.NotFoundInDatabaseException;
import org.klodnicki.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController extends ApiController {
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
