package com.dvfu.digital_platform_core.dao;

import java.util.List;

public interface TourCreateNotification {

    TourData getTour();

    ProductData getProduct();

    interface ProductData{
        Long getId();
        String getOriginalTitle();
    }

    interface  TourData {
        Long getId();
        String getTitle();
        OwnerData getOwner();

        interface OwnerData {//название турагенства
            String getUsername();
        }

    }



}

