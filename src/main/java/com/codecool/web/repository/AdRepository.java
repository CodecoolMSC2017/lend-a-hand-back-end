package com.codecool.web.repository;

import com.codecool.web.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

    List<Ad> findAllByOrderByIsPremiumDescTimestampDesc();

    List<Ad> findAllByAdvertiser_IdOrderByIsPremiumDescTimestampDesc(int id);

    Ad findById(int id);

    List<Ad> findAllByCategoryOrderByIsPremiumDescTimestampDesc(String category);

    List<Ad> findAllByTitleContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc(@Nullable String keyword);

    List<Ad> findAllByDescriptionContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc(@Nullable String keyword);

    List<Ad> findAllByTypeOrderByIsPremiumDescTimestampDesc(@Nullable String type);

    List<Ad> findAllByCategoryAndTypeOrderByIsPremiumDescTimestampDesc(@Nullable String category, @Nullable String type);

    //Find ads by keyword and category
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String category);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String category);

    //Find ads by keyword and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String type);

    //Find ads by keyword, category and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String category, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc(@Nullable String keyword, @Nullable String category, @Nullable String type);




}
