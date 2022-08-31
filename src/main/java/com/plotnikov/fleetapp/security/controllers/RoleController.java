package com.plotnikov.fleetapp.security.controllers;

import com.plotnikov.fleetapp.security.models.Role;
import com.plotnikov.fleetapp.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public String getRoles(Model model) {

        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roles", roleList);

        return "role";
    }

    @PostMapping("/roles/addNew")
    public String addNew(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping("/roles/findById")
    @ResponseBody
    public Optional<Role> findById(Integer id) {
        return roleService.findById(id);
    }

    @RequestMapping(value = "/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }
}
