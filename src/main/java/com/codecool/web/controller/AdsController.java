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

    @GetMapping(path = "")
    public List<Ad> getAllAds() {
        return adService.getAll();
    }

    @GetMapping(path = "/advertisers/{id}")
    public List<Ad> getAllAdsByAdvertiser(@PathVariable("id") int id) {
        return adService.getAllByAdvertiserId(id);
    }

    @GetMapping(path = "/categories")
    public List<Ad> getAllAdsByCategory(@RequestParam(value = "category", required = false) String categoryOrNull) {
        return adService.getAllByCategory(categoryOrNull);
    }

    @GetMapping(path = "/keywords")
    public List<Ad> getAllAdsByKeyword(@RequestParam(value = "keyword", required = false) String keywordOrNull) {
        return adService.getAllByTitleOrDescriptionContaining(keywordOrNull);
    }

    @GetMapping(path = "/types")
    public List<Ad> getAllAdsByType(@RequestParam(value = "type", required = false) String typeOrNull) {
        return adService.getAllByType(typeOrNull);
    }

    @GetMapping(path = "/categories-types")
    public List<Ad> getAllAdsByCategoryAndType(@RequestParam(value = "category", required = false) String categoryOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return adService.getAllByCategoryAndType(categoryOrNull, typeOrNull);
    }

    @GetMapping(path = "/keywords-types")
    public List<Ad> getAllAdsByKeywordAndType(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return adService.getAllByKeywordAndType(keywordOrNull, typeOrNull);
    }

    @GetMapping(path = "/keyword-category")
    public List<Ad> getAllAdsByKeywordAndCategory(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "category", required = false) String categoryOrNull) {
        return adService.getAllByKeywordAndCategory(keywordOrNull, categoryOrNull);
    }

    @GetMapping(path = "/keywords-categories-types")
    public List<Ad> getAllAdsByKeywordAndCategoryAndType(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "category", required = false) String categoryOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return adService.getAllByKeywordAndCategoryAndType(keywordOrNull, categoryOrNull, typeOrNull);
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
    public void deleteAdById(@PathVariable("id") int id) {
        adService.deleteAd(id);
    }

    @PutMapping(path = "/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Ad updateAd(@RequestBody Ad ad) {
        return adService.updateAdData(ad);
    }

}
