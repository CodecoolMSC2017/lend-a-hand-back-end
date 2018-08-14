package com.codecool.web.service;

import com.codecool.web.dto.AdDto;
import com.codecool.web.model.Ad;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AdService {

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository uRepo;

    public List<Ad> getAll() {
        return adRepository.findAllByOrderByIsPremiumDescTimestampDesc();
    }

    public List<Ad> getAllByAdvertiserId(int id) {
        return adRepository.findAllByAdvertiser_IdOrderByIsPremiumDescTimestampDesc(id);
    }

    public List<Ad> getAllByCategory(String category) {
        return adRepository.findAllByCategoryOrderByIsPremiumDescTimestampDesc(category);
    }

    public List<Ad> getAllByType(String type) {
        return adRepository.findAllByTypeOrderByIsPremiumDescTimestampDesc(type);
    }

    public List<Ad> getAllByCategoryAndType(String category, String type) {
        return adRepository.findAllByCategoryAndTypeOrderByIsPremiumDescTimestampDesc(category, type);
    }

    public List<Ad> getAllByTitleOrDescriptionContaining(String keyword) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc(keyword));
        List<Ad> adsByDescription = adRepository.findAllByDescriptionContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc(keyword);
        for (Ad ad : adsByDescription){
            if(!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndCategory(String keyword, String category) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc(keyword, category));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByDescriptionContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc(keyword, category);
        for (Ad ad : adsByDescriptionAndCategory) {
            if(!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndType(String keyword, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc(keyword, type));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByDescriptionContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc(keyword, type);
        for (Ad ad : adsByDescriptionAndCategory) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndCategoryAndType(String keyword, String category, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc(keyword, category, type));
        List<Ad> adsByDescriptionAndCategoryAndType = adRepository.findAllByDescriptionContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc(keyword, category, type);
        for (Ad ad : adsByDescriptionAndCategoryAndType) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByFilter(String keyword, String category, String type) {
        List<Ad> filteredAds = new ArrayList<>();
        if (keyword.equals("") && category.equals("All") && type.equals("All")) {
            filteredAds = getAll();
        }

        if (!keyword.equals("") && category.equals("All") && type.equals("All")) {
            filteredAds = getAllByTitleOrDescriptionContaining(keyword);
        }

        if (keyword.equals("") && !category.equals("All") && type.equals("All")) {
            filteredAds = getAllByCategory(category);
        }

        if (keyword.equals("") && category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByType(type);
        }

        if (!keyword.equals("") && !category.equals("All") && type.equals("All")) {
            filteredAds = getAllByKeywordAndCategory(keyword, category);
        }

        if (!keyword.equals("") && category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByKeywordAndType(keyword, type);
        }

        if (keyword.equals("") && !category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByCategoryAndType(category, type);
        }

        if (!keyword.equals("") && !category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByKeywordAndCategoryAndType(keyword, category, type);
        }

        return filteredAds;
    }

    public Ad getById(int id) {
        return adRepository.findById(id);
    }

    public Ad addNewAd(AdDto adDto) {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        adDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        adDto.setState("Pending");
        Ad ad = new Ad(adDto, uRepo.findById(adDto.getAdvertiserId()));
        adRepository.save(ad);
        return ad;
    }

    public void deleteAd(int id) {
        adRepository.deleteById(id);
    }

    public Ad updateAdData(Ad ad) {
        adRepository.save(ad);
        return ad;
    }


}
