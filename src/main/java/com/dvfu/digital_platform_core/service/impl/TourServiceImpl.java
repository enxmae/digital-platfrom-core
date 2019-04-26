package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.repository.TourRepository;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour findTourById(Long id){
        return tourRepository.findTourById(id);

    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> findAll(Long ownerId) {
        return tourRepository.findAllByOwner_Id(ownerId);
    }

    public Tour insert(Tour tour) {
        return tourRepository.save(tour);
    }
}
