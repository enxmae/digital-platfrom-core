package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.TourCreateNotification;
import com.dvfu.digital_platform_core.repository.TourRepository;
import com.dvfu.digital_platform_core.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final TourRepository tourRepository;

    NotificationServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<TourCreateNotification> sendNotification(Long productsOwnerId) {
        return tourRepository.findToursByProducts_Owner_Id(productsOwnerId);
    }
}
