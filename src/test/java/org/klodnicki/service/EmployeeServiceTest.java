package org.klodnicki.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTORequest;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.klodnicki.exception.NotFoundInDatabaseException;
import org.klodnicki.model.entity.Employee;
import org.klodnicki.repository.EmployeeRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    private static final Long NON_EXISTENT_ID = 999L;
    private static final Long EXISTENT_ID = 1L;


    @BeforeEach
    void setUp() {
        // Tworzę przykładowe obiekty, które będą używane w testach
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

    @Test
    public void deleteById_ShouldThrowNotFoundInDatabaseException_WhenEmployeeNotExist() {
        //Arrange
        when(employeeRepository.findById(NON_EXISTENT_ID)).thenReturn(Optional.empty());

        //Act and assert
        assertThrows(NotFoundInDatabaseException.class, ()-> employeeService.deleteById(NON_EXISTENT_ID));

        // Upewniam się, że metoda delete() nie została wywołana, bo wcześniej powinien zostać rzucony wyjątek.
        verify(employeeRepository, never()).delete(any(Employee.class));
    }

    @Test
    public void deleteById_ShouldFindAndDeleteEmployee_WhenEmployeeIdIsGiven() throws NotFoundInDatabaseException {
        //Arrange
        when(employeeRepository.findById(EXISTENT_ID)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepository).delete(employee);

        //Act
        employeeService.deleteById(EXISTENT_ID);

        // Assert - Sprawdzam czy wywołano `findById()` i `delete()`
        verify(employeeRepository).findById(EXISTENT_ID);
        verify(employeeRepository).delete(employee);
    }

    @Test
    public void findById_ShouldThrowNotFoundInDatabaseException_WhenEmployeeNotExist() {
        //Arrange
        when(employeeRepository.findById(NON_EXISTENT_ID)).thenReturn(Optional.empty());

        //Act & assert
        assertThrows(NotFoundInDatabaseException.class, ()-> employeeService.findById(NON_EXISTENT_ID));
    }

    @Test
    public void findById_ShouldFindAndReturnMappedEmployee_WhenEmployeeExists() throws NotFoundInDatabaseException {
        //Arrange
        when(employeeRepository.findById(EXISTENT_ID)).thenReturn(Optional.of(employee));
        when(modelMapper.map(employee, EmployeeDTOResponse.class)).thenReturn(employeeDTOResponse);

        //Act
        EmployeeDTOResponse actualResponse = employeeService.findById(EXISTENT_ID);

        //Assert
        assertNotNull(actualResponse);
        assertEquals(employeeDTOResponse, actualResponse);
    }
}