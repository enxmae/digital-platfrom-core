package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tours")
public class TourController {

    private final TourService tourService;

    TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable Long id) {
        return tourService.findTourById(id);
    }

    @GetMapping("/tour_operator/{ownerId}")
    @PreAuthorize("hasRole('TOUR_OPERATOR')")
    public List<Tour> getSPNAsProducts(@PathVariable Long ownerId) {
        return tourService.findAll(ownerId);
    }

    @GetMapping
    public List<Tour> getAll() {
        return tourService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('TOUR_OPERATOR')")
    public Tour insert(@RequestBody Tour tour) {
        return tourService.insert(tour);
    }


}
