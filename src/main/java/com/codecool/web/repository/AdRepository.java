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

    List<Ad> findAllByType(@Nullable String type);

    List<Ad> findAllByCategoryAndType(@Nullable String category, @Nullable String type);

    //Find ads by keyword and category
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategory(@Nullable String keyword, @Nullable String category);
    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategory(@Nullable String keyword, @Nullable String category);

    //Find ads by keyword and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndType(@Nullable String keyword, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndType(@Nullable String keyword, @Nullable String type);

    //Find ads by keyword, category and type
    List<Ad> findAllByTitleContainingIgnoreCaseAndCategoryAndType(@Nullable String keyword, @Nullable String category, @Nullable String type);

    List<Ad> findAllByDescriptionContainingIgnoreCaseAndCategoryAndType(@Nullable String keyword, @Nullable String category, @Nullable String type);


}
