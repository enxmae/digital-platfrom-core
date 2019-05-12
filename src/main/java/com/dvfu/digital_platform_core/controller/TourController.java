package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.*;
import com.dvfu.digital_platform_core.repository.TourProductRepository;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TourResponse getTourById(@PathVariable Long id) {
        return tourService.findTourById(id);
    }

    @GetMapping("/tour_operator/{ownerId}")
    @PreAuthorize("hasRole('TOUR_OPERATOR')")
    public List<TourResponse> getTourOperatorsTours(@PathVariable Long ownerId) {
        return tourService.findAll(ownerId);
    }

    @GetMapping
    public List<TourResponse> getAll() {
        return tourService.findAll();
    }
    
    @PostMapping
    @PreAuthorize("hasRole('TOUR_OPERATOR')")
    public Tour insert(@RequestBody TourRequest tour) {
        return tourService.insert(tour);
    }

    ///delete
    ///edit

    @PutMapping("/vote")
    public TourProduct vote4ToursProductProgress(@RequestBody TourProduct tourProduct) {
        return tourService.setProductProgress(tourProduct);
    }

}
