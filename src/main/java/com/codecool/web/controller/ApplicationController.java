package com.codecool.web.controller;

import com.codecool.web.Utility;
import com.codecool.web.dto.ApplicationDto;
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
    public List<ApplicationDto> getAllApplications() {
        return Utility.convertApplicationListToApplicationDtoList(applicationService.getAll());
    }

    @GetMapping("/{id}")
    public ApplicationDto getApplicationById(@PathVariable("id") int id) {
        return new ApplicationDto(applicationService.getById(id));
    }

    @GetMapping("/applicants/{id}")
    public List<ApplicationDto> getAllApplicationsByApplicantId(@PathVariable("id") int id) {
        return Utility.convertApplicationListToApplicationDtoList(applicationService.getAllByApplicantIdOrderByTimestampDesc(id));
    }

    @GetMapping("/ads/{id}")
    public List<ApplicationDto> getAllApplicationsByAdId(@PathVariable("id") int id) {
        return Utility.convertApplicationListToApplicationDtoList(applicationService.getAllByAdIdOrderByTimestampAsc(id));
    }

    @PostMapping("/new")
    public ApplicationDto createNewApplication(@RequestBody Application application) {
        return new ApplicationDto(applicationService.addNewApplication(application));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplicationById(@PathVariable("id") int id) {
        applicationService.deleteApplication(id);
    }

    @PutMapping("/update")
    public ApplicationDto updateApplication(@RequestBody Application application) {
        return new ApplicationDto(applicationService.updateApplicationData(application));
    }
}
