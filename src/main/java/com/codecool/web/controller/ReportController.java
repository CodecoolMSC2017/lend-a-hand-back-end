package com.codecool.web.controller;

import com.codecool.web.Utility;
import com.codecool.web.dto.ReportDto;
import com.codecool.web.model.Report;
import com.codecool.web.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(path = "")
    public List<ReportDto> getAllReports() {
        return Utility.convertReportListToReportDtoList(reportService.getAll());
    }

    @GetMapping(path = "/users/{id}")
    public List<ReportDto> getAllReportsByReportedUser(@PathVariable("id") int id) {
        return Utility.convertReportListToReportDtoList(reportService.getAllByReportedUserId(id));
    }

    @GetMapping(path = "/ads/{id}")
    public List<ReportDto> getAllReportsByReportedAd(@PathVariable("id") int id) {
        return Utility.convertReportListToReportDtoList(reportService.getAllByReportedAdId(id));
    }

    @PostMapping(path = "/new",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ReportDto createNewReport(@RequestBody ReportDto reportDto) {
        Report report = reportService.addNewReport(reportDto);
        return new ReportDto(report);
    }

    @PutMapping(path = "/update/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Report updateReport(@PathVariable int id) {
        return reportService.handleReport(id);
    }
}
