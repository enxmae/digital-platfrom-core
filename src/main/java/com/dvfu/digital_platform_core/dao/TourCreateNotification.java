package com.dvfu.digital_platform_core.dao;

import java.util.List;

public interface TourCreateNotification {

    TourData getTour();

    ProductData getProduct();

    interface ProductData{
        String getOriginalTitle();
        OwnerData getOwner();

        interface OwnerData {
            String getId();
        }

    }

    interface  TourData {
        String getTitle();
        OwnerData getOwner();

        interface OwnerData {//название турагенства
            String getUsername();
        }

    }



}
