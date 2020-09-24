package com.perficient.esa.service;

import com.perficient.esa.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee editEmployee, Long id);
    void deleteEmployee(Long id);
}
