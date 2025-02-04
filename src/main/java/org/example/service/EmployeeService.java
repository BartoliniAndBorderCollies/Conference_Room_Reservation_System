package org.example.service;

import lombok.AllArgsConstructor;
import org.example.DTO.EmployeeDTO.EmployeeDTORequest;
import org.example.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.example.DTO.ResponseDTO;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.generic.GenericBasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements GenericBasicCrudOperations<EmployeeDTOResponse, EmployeeDTORequest> {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDTOResponse create(EmployeeDTORequest employeeDTORequest) {

        Employee employeeToBeSaved = modelMapper.map(employeeDTORequest, Employee.class);
        employeeRepository.save(employeeToBeSaved);

        return modelMapper.map(employeeToBeSaved, EmployeeDTOResponse.class);
    }

    @Override
    public ResponseDTO delete(EmployeeDTORequest object) {
        return null;
    }

}
