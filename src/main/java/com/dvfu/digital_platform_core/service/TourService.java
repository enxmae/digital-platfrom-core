package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.*;

import java.util.List;

public interface TourService {

    //TourNotification findTourById(Long id);
    TourResponse findTourById(Long id);

    List<TourResponse> findAll();

    List<TourResponse> findAll(Long ownerId);

    Tour insert(TourRequest tourRequest);

    List<ToursProducts> test(Long tourId);

    boolean checkTourProgressOK(Long tourId);

    TourResponse createTourResponse(Tour tour, List<ToursProducts> products);

    Tour createTour(TourRequest tourRequest);

    TourProduct setProductProgress(TourProduct tourProduct);

}
