package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.JobTitle;
import com.plotnikov.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired private JobTitleService jobTitleService;

    @GetMapping("/job_titles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        return "job_title";
    }

    @PostMapping("/job_titles/addNew")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/job_titles";
    }

    @RequestMapping("/job_titles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id) {
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/job_titles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/job_titles";
    }

    @RequestMapping(value = "/job_titles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        jobTitleService.delete(id);
        return "redirect:/job_titles";
    }
}
