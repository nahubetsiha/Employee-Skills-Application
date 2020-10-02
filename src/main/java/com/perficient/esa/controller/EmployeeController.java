package com.perficient.esa.controller;

import com.perficient.esa.model.Employee;
import com.perficient.esa.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();

        if(employees.isEmpty()){
            return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee){
        employeeService.updateEmployee(employee, employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    ResponseEntity<Employee> deleteEmployee(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
