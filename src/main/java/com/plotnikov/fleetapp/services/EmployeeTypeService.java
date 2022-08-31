package com.plotnikov.fleetapp.services;

import com.plotnikov.fleetapp.models.Employee;
import com.plotnikov.fleetapp.models.EmployeeType;
import com.plotnikov.fleetapp.models.User;
import com.plotnikov.fleetapp.repositories.EmployeeRepository;
import com.plotnikov.fleetapp.repositories.EmployeeTypeRepository;
import com.plotnikov.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
