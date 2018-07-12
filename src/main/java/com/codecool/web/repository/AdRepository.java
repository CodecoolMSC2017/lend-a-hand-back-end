package com.codecool.web.repository;

import com.codecool.web.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

    @Override
    List<Ad> findAll();
    List<Ad> findAllByAdvertiser_Id(int id);
    Ad findById(int id);
    List<Ad> findAllByCategory(String category);
    List<Ad> findAllByDescriptionContaining(String keyword);
}
