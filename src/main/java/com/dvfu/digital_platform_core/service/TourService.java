package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Tour;

import java.util.List;

public interface TourService {

    //TourNotification findTourById(Long id);
    Tour findTourById(Long id);

    List<Tour> findAll();

    List<Tour> findAll(Long ownerId);

    Tour insert(Tour tour);

}
