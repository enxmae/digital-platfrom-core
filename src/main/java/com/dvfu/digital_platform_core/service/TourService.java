package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.Tour;

import java.util.List;

public interface TourService {

    Tour findTourById(Long id);

    Tour insert(Tour tour, List<Product> products);

}
