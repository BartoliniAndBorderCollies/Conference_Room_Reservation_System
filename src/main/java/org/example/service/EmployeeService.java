package org.example.service;

import lombok.AllArgsConstructor;
import org.example.DTO.EmployeeDTO.EmployeeDTORequest;
import org.example.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.example.exception.NotFoundInDatabaseException;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.generic.GenericBasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements GenericBasicCrudOperations<EmployeeDTOResponse, EmployeeDTORequest, Long> {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDTOResponse create(EmployeeDTORequest employeeDTORequest) {

        Employee employeeToBeSaved = modelMapper.map(employeeDTORequest, Employee.class);
        employeeRepository.save(employeeToBeSaved);

        return modelMapper.map(employeeToBeSaved, EmployeeDTOResponse.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundInDatabaseException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundInDatabaseException(Employee.class));
        employeeRepository.delete(employee);
    }
}
