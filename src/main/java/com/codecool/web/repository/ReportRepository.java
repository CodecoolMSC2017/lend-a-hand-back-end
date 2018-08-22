package com.codecool.web.repository;

import com.codecool.web.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Override
    List<Report> findAll();
    List<Report> findAllByReportedUserIsNull();
    List<Report> findAllByReportedAdIsNull();
    Report findById(int id);

}
