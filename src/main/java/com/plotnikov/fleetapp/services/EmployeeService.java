package com.plotnikov.fleetapp.services;

import com.plotnikov.fleetapp.models.Employee;
import com.plotnikov.fleetapp.models.User;
import com.plotnikov.fleetapp.repositories.EmployeeRepository;
import com.plotnikov.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private UserRepository userRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void save(Employee vehicleHire) {
        employeeRepository.save(vehicleHire);
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    public void assignUsername(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
