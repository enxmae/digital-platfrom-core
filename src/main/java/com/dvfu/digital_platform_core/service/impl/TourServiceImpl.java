package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.repository.TourRepository;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Note findTourById(Long id){
        return tourRepository.findTourById(id);

    }

    public Tour insert(Tour tour) {
        return tourRepository.save(tour);
    }
}
