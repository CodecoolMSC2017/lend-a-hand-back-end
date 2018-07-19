package com.codecool.web.controller;

import com.codecool.web.model.Application;
import com.codecool.web.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping(path = "")
    public List<Application> getAllApplications() {
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable("id") int id) {
        return applicationService.getById(id);
    }

    @GetMapping("/applicants/{id}")
    public List<Application> getAllApplicationsByApplicantId(@PathVariable("id") int id) {
        return applicationService.getAllByApplicantIdOrderByTimestampDesc(id);
    }

    @GetMapping("/ads/{id}")
    public List<Application> getAllApplicationsByAdId(@PathVariable("id") int id) {
        return applicationService.getAllByAdIdOrderByTimestampAsc(id);
    }

    @PostMapping("/new")
    public Application createNewApplication(@RequestBody Application application) {
        return applicationService.addNewApplication(application);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplicationById(@PathVariable("id") int id) {
        applicationService.deleteApplication(id);
    }

    @PutMapping("/update")
    public Application updateApplication(@RequestBody Application application) {
        return applicationService.updateApplicationData(application);
    }
}
