package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.EmployeeType;
import com.plotnikov.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired private EmployeeTypeService employeeTypeService;

    @GetMapping("/employee_types")
    public String getEmployeeTypes(Model model) {
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

        model.addAttribute("employeeTypes", employeeTypeList);

        return "employee_type";
    }

    @PostMapping("/employee_types/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employee_types";
    }

    @RequestMapping("/employee_types/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employee_types/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employee_types";
    }

    @RequestMapping(value = "/employee_types/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employee_types";
    }
}
