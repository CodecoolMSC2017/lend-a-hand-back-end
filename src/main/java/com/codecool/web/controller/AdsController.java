package com.codecool.web.controller;

import com.codecool.web.model.Ad;
import com.codecool.web.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/advertisers/{1}")
    public List<Ad> getAllAdsByAdvertiser(@PathVariable("id") int id) {
        return adService.getAllByAdvertiserId(id);
    }

    @GetMapping(path = "/categories/{category}")
    public List<Ad> getAllAdsByCategory(@PathVariable("category") String category) {
        return adService.getAllByCategory(category);
    }

    @GetMapping(path = "/{keyword}")
    public List<Ad> getAllAdsByKeyword(@PathVariable("keyword") String keyword) {
        return adService.getAllByDescriptionContaining(keyword);
    }
}
