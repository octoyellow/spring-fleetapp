package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.Client;
import com.plotnikov.fleetapp.models.Location;
import com.plotnikov.fleetapp.models.Vehicle;
import com.plotnikov.fleetapp.models.VehicleHire;
import com.plotnikov.fleetapp.services.ClientService;
import com.plotnikov.fleetapp.services.LocationService;
import com.plotnikov.fleetapp.services.VehicleHireService;
import com.plotnikov.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired private VehicleHireService vehicleHireService;
    @Autowired private VehicleService vehicleService;
    @Autowired private LocationService locationService;
    @Autowired private ClientService clientService;

    @GetMapping("/vehicle_hires")
    public String getVehicleHires(Model model) {
        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHireList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        return "vehicle_hire";
    }

    @PostMapping("/vehicle_hires/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicle_hires";
    }

    @RequestMapping("/vehicle_hires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicle_hires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicle_hires";
    }

    @RequestMapping(value = "/vehicle_hires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicle_hires";
    }
}
