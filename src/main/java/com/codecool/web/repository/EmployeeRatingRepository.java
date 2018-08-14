package com.codecool.web.repository;

import com.codecool.web.model.EmployeeRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRatingRepository extends JpaRepository<EmployeeRating, Integer> {

    @Override
    List<EmployeeRating> findAll();

    EmployeeRating findById(int id);

    List<EmployeeRating> findAllByRater_Id(int id);

    List<EmployeeRating> findAllByRated_Id(int id);

}
