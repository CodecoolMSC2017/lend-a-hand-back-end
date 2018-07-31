package com.codecool.web.controller;

import com.codecool.web.Utility;
import com.codecool.web.dto.AdDto;
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
    public List<AdDto> getAllAdsByAdvertiser(@PathVariable("id") int id) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByAdvertiserId(id));
    }

    @GetMapping(path = "/filters")
    public List<AdDto> getAllAdsByFilter(@RequestParam(value = "keyword", required = false) String keywordOrNull,
                                         @RequestParam(value = "category", required = false) String categoryOrNull,
                                         @RequestParam(value = "type", required = false) String typeOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByFilter(keywordOrNull, categoryOrNull, typeOrNull));
    }
    /*
    @GetMapping(path = "/categories")
    public List<AdDto> getAllAdsByCategory(@RequestParam(value = "category", required = false) String categoryOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByCategory(categoryOrNull));
    }

    @GetMapping(path = "/keywords")
    public List<AdDto> getAllAdsByKeyword(@RequestParam(value = "keyword", required = false) String keywordOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByTitleOrDescriptionContaining(keywordOrNull));
    }

    @GetMapping(path = "/types")
    public List<AdDto> getAllAdsByType(@RequestParam(value = "type", required = false) String typeOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByType(typeOrNull));
    }

    @GetMapping(path = "/categories-types")
    public List<AdDto> getAllAdsByCategoryAndType(@RequestParam(value = "category", required = false) String categoryOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByCategoryAndType(categoryOrNull, typeOrNull));
    }

    @GetMapping(path = "/keywords-types")
    public List<AdDto> getAllAdsByKeywordAndType(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByKeywordAndType(keywordOrNull, typeOrNull));
    }

    @GetMapping(path = "/keywords-categories")
    public List<AdDto> getAllAdsByKeywordAndCategory(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "category", required = false) String categoryOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByKeywordAndCategory(keywordOrNull, categoryOrNull));
    }

    @GetMapping(path = "/keywords-categories-types")
    public List<AdDto> getAllAdsByKeywordAndCategoryAndType(@RequestParam(value = "keyword", required = false) String keywordOrNull, @RequestParam(value = "category", required = false) String categoryOrNull, @RequestParam(value = "type", required = false) String typeOrNull) {
        return Utility.convertAdListtoAdDtoList(adService.getAllByKeywordAndCategoryAndType(keywordOrNull, categoryOrNull, typeOrNull));
    }
    */

    @GetMapping(path = "/{id}")
    public AdDto getAdById(@PathVariable("id") int id) {
        return new AdDto(adService.getById(id));
    }

    @PostMapping(path = "/new",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public AdDto createNewAd(@RequestBody AdDto ad) {
        Ad tmpAd = adService.addNewAd(ad);
        return new AdDto(tmpAd);
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
