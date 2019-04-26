package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.TourCreateNotification;

import java.util.List;

public interface NotificationService {

    List<TourCreateNotification> sendNotification(Long productsOwnerId);

}
