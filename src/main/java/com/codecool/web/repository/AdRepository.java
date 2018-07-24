package com.codecool.web.repository;

import com.codecool.web.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

    @Override
    List<Ad> findAll();
    List<Ad> findAllByAdvertiser_Id(int id);
    Ad findById(int id);
    List<Ad> findAllByCategory(String category);
    List<Ad> findAllByTitleContainingIgnoreCase(@Nullable String keyword);
    List<Ad> findAllByDescriptionContainingIgnoreCase(@Nullable String keyword);
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategory(@Nullable String keyword, @Nullable String category);
    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategory(@Nullable String keyword, @Nullable String category);
}
