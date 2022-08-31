package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.*;
import com.plotnikov.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;
    @Autowired private EmployeeTypeService employeeTypeService;
    @Autowired private JobTitleService jobTitleService;
    @Autowired private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees(Model model) {

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);

        return "employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/assignUsername")
    public String assignUsername(int id) {
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }
}
