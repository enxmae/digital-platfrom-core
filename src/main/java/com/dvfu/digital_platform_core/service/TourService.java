package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.dto.TourNotification;

import java.util.Collection;
import java.util.List;

public interface TourService {

    //TourNotification findTourById(Long id);
    Tour findTourById(Long id);

    List<Tour> findAll();

    Tour insert(Tour tour);

}
