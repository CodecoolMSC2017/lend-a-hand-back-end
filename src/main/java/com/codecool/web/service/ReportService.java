package com.codecool.web.service;

import com.codecool.web.dto.ReportDto;
import com.codecool.web.model.Ad;
import com.codecool.web.model.Report;
import com.codecool.web.model.User;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.ReportRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    public List<Report> getAllByReportedUserId(int id) {
        return reportRepository.findAllByReportedUser_Id(id);
    }

    public List<Report> getAllByReportedAdId(int id) {
        return reportRepository.findAllByReportedAd_Id(id);
    }

    public Report addNewReport(ReportDto reportDto) {
        User reporter = userRepository.findById(reportDto.getReporterId());
        User reportedUser = userRepository.findById(reportDto.getReportedUserId());
        Ad reportedAd = adRepository.findById(reportDto.getReportedAdId());

        reportDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        reportDto.setHandled(false);
        Report report = new Report(reportDto, reporter, reportedUser, reportedAd);
        reportRepository.save(report);
        return report;
    }

    public Report handleReport(int id) {
        Report report = reportRepository.findById(id);
        report.setHandled(true);
        return reportRepository.save(report);
    }
}
