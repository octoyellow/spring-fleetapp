package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.VehicleModel;
import com.plotnikov.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired private VehicleModelService vehicleModelService;

    @GetMapping("/vehicle_models")
    public String getVehicleModels(Model model) {
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

        model.addAttribute("vehicleModels", vehicleModelList);

        return "vehicle_model";
    }

    @PostMapping("/vehicle_models/addNew")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle_models";
    }

    @RequestMapping("/vehicle_models/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehicle_models/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle_models";
    }

    @RequestMapping(value = "/vehicle_models/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicle_models";
    }
}
