package com.codecool.web.service;

import com.codecool.web.model.Report;
import com.codecool.web.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    public List<Report> getAllByReportedUserId(int id) {
        return reportRepository.findAllByReportedUser_Id(id);
    }

    public List<Report> getAllByReportedAdId(int id) {
        return reportRepository.findAllByReportedAd_Id(id);
    }
}
