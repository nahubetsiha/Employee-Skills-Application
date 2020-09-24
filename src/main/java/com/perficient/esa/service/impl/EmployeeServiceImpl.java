package com.perficient.esa.service.impl;

import com.perficient.esa.model.Employee;
import com.perficient.esa.repository.EmployeeRepository;
import com.perficient.esa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public Employee getEmployeeById(Long id) {
//        if(employeeRepository.getOne(id)==null) {
//            throw new EntityNotFoundException(Employee.class, "id", id);
//        }
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee updateEmployee(Employee editEmployee, Long id) {
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
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            employeeRepository.deleteById(id);
        }
    }
}
