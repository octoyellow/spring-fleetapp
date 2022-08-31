package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.Location;
import com.plotnikov.fleetapp.models.Supplier;
import com.plotnikov.fleetapp.models.Vehicle;
import com.plotnikov.fleetapp.models.VehicleMovement;
import com.plotnikov.fleetapp.services.LocationService;
import com.plotnikov.fleetapp.services.SupplierService;
import com.plotnikov.fleetapp.services.VehicleMovementService;
import com.plotnikov.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired private VehicleMovementService vehicleMovementService;
    @Autowired private VehicleService vehicleService;
    @Autowired private LocationService locationService;

    @GetMapping("/vehicle_movements")
    public String getVehicleMovements(Model model) {
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements", vehicleMovementList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        return "vehicle_movement";
    }

    @PostMapping("/vehicle_movements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicle_movements";
    }

    @RequestMapping("/vehicle_movements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id) {
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicle_movements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicle_movements";
    }

    @RequestMapping(value = "/vehicle_movements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicle_movements";
    }
}
