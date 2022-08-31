package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String un);
}
