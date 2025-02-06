package org.klodnicki.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTORequest;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.klodnicki.model.entity.Employee;
import org.klodnicki.repository.EmployeeRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    private EmployeeDTORequest employeeDTORequest;
    private Employee employee;
    private EmployeeDTOResponse employeeDTOResponse;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeDTORequest = new EmployeeDTORequest("Adam", "Brown");
        employee = new Employee(1L, "Adam", "Brown",new ArrayList<>());
        employeeDTOResponse = new EmployeeDTOResponse(1L, "Adam", "Brown", new ArrayList<>());
    }

    @Test
    public void create_ShouldMapSaveAndMapAgain_WhenEmployeeDTORequestIsGiven() {
        //Arrange - obsługuję miejsca, w kodzie gdzie jest mockowanie
        when(modelMapper.map(employeeDTORequest, Employee.class)).thenReturn(employee);
        when(employeeRepository.save(employee)).thenReturn(employee);
        when(modelMapper.map(employee, EmployeeDTOResponse.class)).thenReturn(employeeDTOResponse);

        //Act
        EmployeeDTOResponse actualResponse = employeeService.create(employeeDTORequest);

        //Assert
        assertNotNull(actualResponse);
        assertEquals(employeeDTOResponse, actualResponse);

        // Verify - sprawdzam tu wywołania metod na mockach
        verify(modelMapper).map(employeeDTORequest, Employee.class);
        verify(employeeRepository).save(employee);
        verify(modelMapper).map(employee, EmployeeDTOResponse.class);
    }

}