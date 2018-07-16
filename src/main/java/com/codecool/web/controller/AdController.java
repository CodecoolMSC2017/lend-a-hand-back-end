package com.codecool.web.controller;

import com.codecool.web.model.Ad;
import com.codecool.web.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class AdController {

    @Autowired
    AdService adService;

    @GetMapping(path = "/{id}")
    public Ad getAdById(@PathVariable("id") int id) {
        return adService.getById(id);
    }
}
