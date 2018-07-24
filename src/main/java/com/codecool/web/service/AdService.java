package com.codecool.web.service;

import com.codecool.web.model.Ad;
import com.codecool.web.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    public List<Ad> getAllByAdvertiserId(int id) {
        return adRepository.findAllByAdvertiser_Id(id);
    }

    public List<Ad> getAllByCategory(String category) {
        return adRepository.findAllByCategory(category);
    }

    public List<Ad> getAllByType(String type) {
        return adRepository.findAllByType(type);
    }

    public List<Ad> getAllByCategoryAndType(String category, String type) {
        return adRepository.findAllByCategoryAndType(category, type);
    }

    public List<Ad> getAllByTitleOrDescriptionContaining(String keyword) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCase(keyword));
        List<Ad> adsByDescription = adRepository.findAllByDescriptionContainingIgnoreCase(keyword);
        for (Ad ad : adsByDescription){
            if(!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndCategory(String keyword, String category) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndCategory(keyword, category));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByDescriptionContainingIgnoreCaseAndCategory(keyword, category);
        for (Ad ad : adsByDescriptionAndCategory) {
            if(!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndType(String keyword, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndType(keyword, type));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByDescriptionContainingIgnoreCaseAndType(keyword, type);
        for (Ad ad : adsByDescriptionAndCategory) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByKeywordAndCategoryAndType(String keyword, String category, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByTitleContainingIgnoreCaseAndCategoryAndType(keyword, category, type));
        List<Ad> adsByDescriptionAndCategoryAndType = adRepository.findAllByDescriptionContainingIgnoreCaseAndCategoryAndType(keyword, category, type);
        for (Ad ad : adsByDescriptionAndCategoryAndType) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public Ad getById(int id) {
        return adRepository.findById(id);
    }

    public Ad addNewAd(Ad ad) {
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
