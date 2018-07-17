package com.codecool.web.controller;

import com.codecool.web.model.Ad;
import com.codecool.web.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdsController {

    @Autowired
    AdService adService;

    @GetMapping(path = "/")
    public List<Ad> getAllAds() {
        return adService.getAll();
    }

    @GetMapping(path = "/advertisers/{id}")
    public List<Ad> getAllAdsByAdvertiser(@PathVariable("id") int id) {
        return adService.getAllByAdvertiserId(id);
    }

    @GetMapping(path = "/categories/{category}")
    public List<Ad> getAllAdsByCategory(@PathVariable("category") String category) {
        return adService.getAllByCategory(category);
    }

    @GetMapping(path = "/keywords/{keyword}")
    public List<Ad> getAllAdsByKeyword(@PathVariable("keyword") String keyword) {
        return adService.getAllByTitleOrDescriptionContaining(keyword);
    }

    @GetMapping(path = "/{id}")
    public Ad getAdById(@PathVariable("id") int id) {
        return adService.getById(id);
    }

    @PostMapping(path = "/new",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Ad createNewAd(@RequestBody Ad ad) {
        return adService.addNewAd(ad);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAd(@PathVariable("id") int id) {
        adService.deleteAd(id);
    }

    @PutMapping(path = "/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Ad updateAd(@RequestBody Ad ad) {
        return adService.updateAdData(ad);
    }

}
