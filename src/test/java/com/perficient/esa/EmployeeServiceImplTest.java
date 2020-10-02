package com.perficient.esa;

import com.perficient.esa.model.Employee;
import com.perficient.esa.model.Role;
import com.perficient.esa.repository.EmployeeRepository;
import com.perficient.esa.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceImpTest {
    //mocking our repository
    @Mock
    EmployeeRepository employeeRepository;
    //injecting the test case object
    @InjectMocks
    EmployeeServiceImpl employeeService;
    Employee employee;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        employee=new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setRole(Role.TECHNICAL_CONSULTANT);
        employee.setFirstName("Nahu");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        List<Employee> emp= employeeService.getAllEmployees();
        Assert.assertNotNull(emp);
        Assert.assertEquals(Arrays.asList(employee),emp);
    }

    @Test
    void findById() {

        when(employeeRepository.getOne(anyString())).thenReturn(employee);
        Employee emp= employeeService.getEmployeeById(employee.getId());
        Assert.assertNotNull(emp);
        Assert.assertEquals(employee,emp);
        Assert.assertEquals(employee.getFirstName(),emp.getFirstName());
    }

    @Test
    void findByFirstAndLastName() {

        Employee employee=new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setRole(Role.TECHNICAL_CONSULTANT);
        employee.setFirstName("Nahu");
        employee.setFirstName("Merawi");
        when(employeeRepository.findByFirstNameAndLastName(anyString(),anyString())).thenReturn(employee);
        Employee emp= employeeService.findByFirstAndLastName("doe","jhon");

        // check if the service is not returning null
        Assert.assertNotNull(emp);

        // check if the service is returning the desired object
        Assert.assertEquals(employee,emp);
        Assert.assertEquals(employee.getFirstName(),emp.getFirstName());
    }
}
