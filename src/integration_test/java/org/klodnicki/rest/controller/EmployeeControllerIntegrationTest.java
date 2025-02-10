package org.klodnicki.rest.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTORequest;
import org.klodnicki.DTO.EmployeeDTO.EmployeeDTOResponse;
import org.klodnicki.model.entity.Employee;
import org.klodnicki.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestPropertySource(locations = "/application-test.properties")
class EmployeeControllerIntegrationTest {
    @Autowired
    private WebTestClient webTestClient;
    private static final String MAIN_ENDPOINT = "api/v1/employee";
    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee = new Employee(null, "TestName", "TestLastName", new ArrayList<>());

    @AfterEach
    void cleanDatabase() {
        employeeRepository.deleteAll();
    }

    @BeforeEach
    void saveEmployeeInDatabase() {
        employee = employeeRepository.save(employee); //employee ma w inicjalizacji null, więc przypisuję tu obiekt z poprawnym ID
    }

    @Test
    void create_ShouldCreateEmployeeInDatabaseAndReturnEmployeeDTOResponse_WhenEmployeeDTORequestIsGiven() {

        EmployeeDTORequest employeeDTORequest = new EmployeeDTORequest("Adam", "Brown");

        webTestClient.post()
                .uri(MAIN_ENDPOINT)
                .bodyValue(employeeDTORequest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(EmployeeDTOResponse.class)
                .consumeWith(response -> {
                    EmployeeDTOResponse actualResponse = response.getResponseBody();
                    assertNotNull(actualResponse);

                    Optional<Employee> optionalEmployee = employeeRepository.findById(actualResponse.getId());
                    assertTrue(optionalEmployee.isPresent(), "Employee not found in database! And it should be there!");
                    Employee employee = optionalEmployee.get();
                    assertEquals(employeeDTORequest.getFirstName(), employee.getFirstName());
                    assertEquals(employeeDTORequest.getLastName(), employee.getLastName());
                });
    }

    @Test
    void delete_ShouldDeleteEmployeeAndReturnNoContentStatus_WhenEmployeeExists() {

        webTestClient.delete()
                .uri(MAIN_ENDPOINT + "/" + employee.getId())
                .exchange()
                .expectStatus().isNoContent()
                .expectBody().isEmpty();

        //Verify
        Optional<Employee> deletedEmployee = employeeRepository.findById(employee.getId());
        assertTrue(deletedEmployee.isEmpty());
    }

}