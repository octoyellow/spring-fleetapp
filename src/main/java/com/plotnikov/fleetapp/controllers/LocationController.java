package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.Country;
import com.plotnikov.fleetapp.models.Location;
import com.plotnikov.fleetapp.models.State;
import com.plotnikov.fleetapp.services.CountryService;
import com.plotnikov.fleetapp.services.LocationService;
import com.plotnikov.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private LocationService locationService;

    @GetMapping("/locations")
    public String getLocations(Model model) {
        List<Location> locationList = locationService.getLocations();
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("states", stateList);
        model.addAttribute("locations", locationList);
        model.addAttribute("countries", countryList);

        return "location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id) {
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
