package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.*;
import com.plotnikov.fleetapp.services.SupplierService;
import com.plotnikov.fleetapp.services.VehicleMaintenanceService;
import com.plotnikov.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired private SupplierService supplierService;
    @Autowired private VehicleService vehicleService;

    @GetMapping("/vehicle_maintenances")
    public String getVehicleMaintenances(Model model) {
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);

        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        return "vehicle_maintenance";
    }

    @PostMapping("/vehicle_maintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle_maintenances";
    }

    @RequestMapping("/vehicle_maintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "/vehicle_maintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle_maintenances";
    }

    @RequestMapping(value = "/vehicle_maintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicle_maintenances";
    }
}
