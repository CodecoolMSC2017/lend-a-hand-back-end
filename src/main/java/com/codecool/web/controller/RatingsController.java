package com.codecool.web.controller;

import com.codecool.web.dto.RatingDto;
import com.codecool.web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    RatingService ratingService;

    @GetMapping(path = "/myratings/{id}")
    public RatingDto getAllMyRatingsBy(@PathVariable("id") int id) {
        return new RatingDto(ratingService.getAllEmployeeRatingByRaterId(id), ratingService.getAllEmployerRatingByRaterId(id));
    }

    @GetMapping(path = "/ratingsaboutme/{id}")
    public RatingDto getAllRatingsAboutmeBy(@PathVariable("id") int id) {
        return new RatingDto(ratingService.getAllEmployeeRatingByRatedId(id), ratingService.getAllEmployerRatingByRatedId(id));
    }



//    @DeleteMapping(path = "/delete/{id}")
//    public void deleteAdById(@PathVariable("id") int id) {
//        ratingService.deleteAd(id);
//    }
//
//    @PutMapping(path = "/update",
//        consumes = MediaType.APPLICATION_JSON_VALUE,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public Ad updateAd(@RequestBody Ad ad) {
//        return ratingService.updateAdData(ad);
//    }

}
