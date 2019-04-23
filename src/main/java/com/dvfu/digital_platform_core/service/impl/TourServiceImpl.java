package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.dto.TourNotification;
import com.dvfu.digital_platform_core.repository.TourRepository;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Note findTourById(Long id){
        return tourRepository.findTourById(id);

    }

    public Tour insert(Tour tour, List<Product> products) {
        tour.setProducts(products);
        return tourRepository.save(tour);
    }
}
