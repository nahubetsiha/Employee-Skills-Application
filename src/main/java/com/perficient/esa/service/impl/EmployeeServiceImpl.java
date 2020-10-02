package com.perficient.esa.service.impl;

import com.perficient.esa.exception.EntityNotFoundException;
import com.perficient.esa.model.Employee;
import com.perficient.esa.repository.EmployeeRepository;
import com.perficient.esa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        if(employeeRepository.getOne(id).equals(null)) {
            throw new EntityNotFoundException(Employee.class,"id",id);
        }

        return employeeRepository.getOne(id);
    }

    @Override
    public Employee findByFirstAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public Employee updateEmployee(Employee editEmployee, String id) {
            return employeeRepository.findById(id)
                    .map(employeeToUpdate -> {
                        employeeToUpdate.setFirstName(editEmployee.getFirstName());
                        employeeToUpdate.setLastName(editEmployee.getLastName());
                        employeeToUpdate.setAddress(editEmployee.getAddress());
                        employeeToUpdate.setEmail(editEmployee.getEmail());
                        employeeToUpdate.setCompanyEmail(editEmployee.getCompanyEmail());
                        employeeToUpdate.setBirthDate(editEmployee.getBirthDate());
                        employeeToUpdate.setHireDate(editEmployee.getHireDate());
                        employeeToUpdate.setRole(editEmployee.getRole());
                        employeeToUpdate.setBusinessUnit(editEmployee.getBusinessUnit());
                        employeeToUpdate.setSkills(editEmployee.getSkills());

                        return employeeRepository.save(employeeToUpdate);
                    }).orElseGet(() -> employeeRepository.save(editEmployee));

    }

    @Override
    public void deleteEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            employeeRepository.deleteById(id);
        }
    }
}
