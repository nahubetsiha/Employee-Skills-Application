package com.perficient.esa.repository;

import com.perficient.esa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByFirstNameAndLastName(String first, String last);
}
