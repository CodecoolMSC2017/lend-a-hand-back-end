package com.codecool.web.service;

import com.codecool.web.dto.ReportDto;
import com.codecool.web.model.*;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.NotificationRepository;
import com.codecool.web.repository.ReportRepository;
import com.codecool.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Report> getAllUserReports() {
        return reportRepository.findAllByReportedAdIsNullOrderByIsHandledAscTimestampAsc();
    }

    public List<Report> getAllAdReports() {
        return reportRepository.findAllByReportedUserIsNullOrderByIsHandledAscTimestampAsc();
    }

    public Report addNewReport(ReportDto reportDto) {
        User reporter = userRepository.findById(reportDto.getReporterId());
        User reportedUser = userRepository.findById(reportDto.getReportedUserId());
        Ad reportedAd = adRepository.findById(reportDto.getReportedAdId());
        reportDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        reportDto.setHandled(false);
        Report report = new Report(reportDto, reporter, reportedUser, reportedAd);
        reportRepository.save(report);

        //Create and save notification
        User admin = userRepository.findByUserName("admin");
        Notification notification = NotificationBuilder.createReportNotification(reporter, admin, report);
        notificationRepository.save(notification);

        if (reportDto.getReportedUserId() == 0) {
            logger.info("New report was made: ID of reporter: " + reportDto.getReporterId() + "; ID of reported ad: " + reportDto.getReportedAdId());
        } else if (reportDto.getReportedAdId() == 0)
            logger.info("New report was made: ID of reporter: " + reportDto.getReporterId() + "; ID of reported user: " + reportDto.getReportedUserId());
        return report;
    }

    public List<Report> handleReport(int id) {
        Report report = reportRepository.findById(id);
        report.setHandled(true);
        reportRepository.save(report);

        if (report.getReportedAd() == null) {
            return getAllUserReports();
        }
        return getAllAdReports();
    }
}
