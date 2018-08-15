package com.codecool.web.repository;

import com.codecool.web.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Override
    List<Report> findAll();
    List<Report> findAllByReportedUser_Id(Integer id);
    List<Report> findAllByReportedAd_Id(Integer id);
    Report findById(int id);

}
