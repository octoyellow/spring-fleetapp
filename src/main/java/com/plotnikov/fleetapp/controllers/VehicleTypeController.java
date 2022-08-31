package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.VehicleType;
import com.plotnikov.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicle_types")
    public String getVehicleTypes(Model model) {

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypeList);

        return "vehicle_type";
    }

    @PostMapping("/vehicle_types/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle_types";
    }

    @RequestMapping("/vehicle_types/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id) {
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicle_types/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle_types";
    }

    @RequestMapping(value = "/vehicle_types/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicle_types";
    }
}
