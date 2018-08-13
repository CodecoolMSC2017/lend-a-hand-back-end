package com.codecool.web.controller;

import com.codecool.web.Utility;
import com.codecool.web.dto.ReportDto;
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
    public List<ReportDto> getAllReports() {
        return Utility.convertReportListToReportDtoList(reportService.getAll());
    }

    @GetMapping(path = "/users/{id}")
    public List<ReportDto> getAllReportsByReportedUsers(@PathVariable("id") int id) {
        return Utility.convertReportListToReportDtoList(reportService.getAllByReportedUserId(id));
    }

    @GetMapping(path = "/ads/{id}")
    public List<ReportDto> getAllReportsByReportedAds(@PathVariable("id") int id) {
        return Utility.convertReportListToReportDtoList(reportService.getAllByReportedAdId(id));
    }
}
