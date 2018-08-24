package com.codecool.web.controller;

import com.codecool.web.dto.RatingDto;
import com.codecool.web.dto.RatingTransferObject;
import com.codecool.web.model.User;
import com.codecool.web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/new",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public User createNewMessage(@RequestBody RatingTransferObject ratingTransferObject) {
        return ratingService.addNewRating(ratingTransferObject);
    }

    @GetMapping(path = "/rated")
    public boolean getIsRated(@RequestParam(value = "userId", required = false) int userId,
                              @RequestParam(value = "applicationId", required = false) Integer applicationId) {
        return ratingService.getIsRated(userId, applicationId);
    }

}
