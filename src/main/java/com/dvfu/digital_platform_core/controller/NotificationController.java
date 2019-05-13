package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.TourCreateNotification;
import com.dvfu.digital_platform_core.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/tours/{ownerId}")
    List<TourCreateNotification> getNotification(@PathVariable Long ownerId) {
        return notificationService.sendNotification(ownerId);
    }

}
