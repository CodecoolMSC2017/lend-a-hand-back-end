package com.codecool.web.repository;

import com.codecool.web.model.EmployerRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRatingRepository extends JpaRepository<EmployerRating, Integer> {

    @Override
    List<EmployerRating> findAll();

    EmployerRating findById(int id);

    List<EmployerRating> findAllByRater_Id(int id);

    List<EmployerRating> findAllByRated_Id(int id);

}
