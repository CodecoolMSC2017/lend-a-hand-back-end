package com.codecool.web.service;

import com.codecool.web.model.Ad;
import com.codecool.web.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Ad getById(int id) {
        return adRepository.findById(id);
    }

    public List<Ad> getAllByCategory(String category) {
        return adRepository.findAllByCategory(category);
    }

    public List<Ad> getAllByDescriptionContaining(String keyword) {
        return adRepository.findAllByDescriptionContaining(keyword);
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
