package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.dao.User;
import com.dvfu.digital_platform_core.dto.TourNotification;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tours")
public class TourController {

    private final TourService tourService;

    TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public Note getTourById(@PathVariable Long id) {
        return tourService.findTourById(id);
    }


    @PostMapping
    public Tour insert(@RequestBody Tour tour) {
        return tourService.insert(tour);
    }


}
