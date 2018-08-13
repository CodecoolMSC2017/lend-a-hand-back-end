package com.codecool.web.controller;

import com.codecool.web.model.Report;
import com.codecool.web.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(path = "")
    public List<Report> getAllReports() {
        return reportService.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public List<Report> getAllReportsByReportedUsers(@PathVariable("id") int id) {
        return reportService.getAllByReportedUserId(id);
    }

    @GetMapping(path = "/ads/{id}")
    public List<Report> getAllReportsByReportedAds(@PathVariable("id") int id) {
        return reportService.getAllByReportedAdId(id);
    }
}
