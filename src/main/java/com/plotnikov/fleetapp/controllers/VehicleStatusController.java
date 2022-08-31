package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.VehicleStatus;
import com.plotnikov.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicle_statuses")
    public String getVehicleStatuses(Model model) {
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();

        model.addAttribute("vehicleStatuses", vehicleStatusList);

        return "vehicle_status";
    }

    @PostMapping("/vehicle_statuses/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle_statuses";
    }

    @RequestMapping("/vehicle_statuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicle_statuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle_statuses";
    }

    @RequestMapping(value = "/vehicle_statuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicle_statuses";
    }
}
