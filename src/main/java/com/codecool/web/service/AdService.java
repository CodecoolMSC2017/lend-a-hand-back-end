package com.codecool.web.service;

import com.codecool.web.dto.AdDto;
import com.codecool.web.model.Ad;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdService {

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository uRepo;

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

    public List<Ad> getAllByFilter(String keyword, String category, String type) {
        if (keyword != "" && category == "All" && type == "All") {
            this.gem.updateKeywordFilter(this.filterSettings.keyword);
        }

        if (this.filterSettings.selectedCategory != = 'All'
            && this.filterSettings.keyword == = ''
            && this.filterSettings.selectedType == = 'All') {
            this.gem.updateCategoryFilter(this.filterSettings.selectedCategory);
        }

        if (this.filterSettings.selectedType != = 'All'
            && this.filterSettings.keyword == = ''
            && this.filterSettings.selectedCategory == = 'All') {
            this.gem.updateTypeFilter(this.filterSettings.selectedType);
        }

        if (this.filterSettings.keyword != = ''
            && this.filterSettings.selectedCategory != = 'All'
            && this.filterSettings.selectedType == = 'All') {
            this.gem.updateKeywordCategoryFilter(new KeywordCategoryFilterModel(this.filterSettings.keyword,
                this.filterSettings.selectedCategory));
        }

        if (this.filterSettings.keyword != = ''
            && this.filterSettings.selectedType != = 'All'
            && this.filterSettings.selectedCategory == = 'All') {
            this.gem.updateKeywordTypeFilter(new KeywordTypeFilterModel(this.filterSettings.keyword,
                this.filterSettings.selectedType));
        }

        if (this.filterSettings.selectedCategory != = 'All'
            && this.filterSettings.selectedType != = 'All'
            && this.filterSettings.keyword == = '') {
            this.gem.updateCategoryTypeFilter(new CategoryTypeFilterModel(this.filterSettings.selectedCategory,
                this.filterSettings.selectedType));
        }

        if (this.filterSettings.keyword != = ''
            && this.filterSettings.selectedCategory != = 'All'
            && this.filterSettings.selectedType != = 'All') {
            this.gem.updateKeywordCategoryTypeFilter(new KeywordCategoryTypeFilterModel(this.filterSettings.keyword,
                this.filterSettings.selectedCategory, this.filterSettings.selectedType));
        }

        if (this.filterSettings.keyword == = ''
            && this.filterSettings.selectedCategory == = 'All'
            && this.filterSettings.selectedType == = 'All') {
            this.gem.updateNoFilter('No filter');
        }
    }

    public Ad getById(int id) {
        return adRepository.findById(id);
    }

    public Ad addNewAd(AdDto adDto) {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
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
