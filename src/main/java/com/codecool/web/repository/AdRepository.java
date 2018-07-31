package com.codecool.web.repository;

import com.codecool.web.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

    List<Ad> findAllByOrderByTimestampDesc();

    List<Ad> findAllByAdvertiser_IdOrderByTimestampDesc(int id);

    Ad findById(int id);

    List<Ad> findAllByCategoryOrderByTimestampDesc(String category);

    List<Ad> findAllByTitleContainingIgnoreCaseOrderByTimestampDesc(@Nullable String keyword);

    List<Ad> findAllByDescriptionContainingIgnoreCaseOrderByTimestampDesc(@Nullable String keyword);

    List<Ad> findAllByTypeOrderByTimestampDesc(@Nullable String type);

    List<Ad> findAllByCategoryAndTypeOrderByTimestampDesc(@Nullable String category, @Nullable String type);

    //Find ads by keyword and category
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategoryOrderByTimestampDesc(@Nullable String keyword, @Nullable String category);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategoryOrderByTimestampDesc(@Nullable String keyword, @Nullable String category);

    //Find ads by keyword and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndTypeOrderByTimestampDesc(@Nullable String keyword, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndTypeOrderByTimestampDesc(@Nullable String keyword, @Nullable String type);

    //Find ads by keyword, category and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategoryAndTypeOrderByTimestampDesc(@Nullable String keyword, @Nullable String category, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategoryAndTypeOrderByTimestampDesc(@Nullable String keyword, @Nullable String category, @Nullable String type);




}
