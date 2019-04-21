package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.Tour;
import com.dvfu.digital_platform_core.dto.TourNotification;

import java.util.Collection;
import java.util.List;

public interface TourService {

    //TourNotification findTourById(Long id);
    Note findTourById(Long id);

    Tour insert(Tour tour, List<Product> products);

}
