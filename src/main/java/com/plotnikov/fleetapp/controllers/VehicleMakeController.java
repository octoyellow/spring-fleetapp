package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.VehicleMake;
import com.plotnikov.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicle_makes")
    public String getVehicleMakes(Model model) {
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

        model.addAttribute("vehicleMakes", vehicleMakeList);

        return "vehicle_make";
    }

    @PostMapping("/vehicle_makes/addNew")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle_makes";
    }

    @RequestMapping("/vehicle_makes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id) {
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehicle_makes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle_makes";
    }

    @RequestMapping(value = "/vehicle_makes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicle_makes";
    }
}
