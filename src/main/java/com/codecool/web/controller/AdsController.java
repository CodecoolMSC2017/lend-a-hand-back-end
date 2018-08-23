package com.codecool.web.controller;

import com.codecool.web.Utility;
import com.codecool.web.dto.AdDto;
import com.codecool.web.dto.SystemMessageDto;
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
    public SystemMessageDto deleteAdById(@PathVariable("id") int id) {
        System.out.println(id);
        adService.deleteAd(id);
        return new SystemMessageDto("Delete completed");
    }

    @PutMapping(path = "/block/{id}")
    public AdDto updateAd(@PathVariable int id) {
        return adService.blockAd(id);
    }

}
