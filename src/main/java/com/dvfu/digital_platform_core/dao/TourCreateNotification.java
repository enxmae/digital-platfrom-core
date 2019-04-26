package com.dvfu.digital_platform_core.dao;

import java.util.List;

public interface TourCreateNotification {

    String getTitle();

    ProductData getProducts();

    OwnerData getOwner();

    interface ProductData{
        String getOriginalTitle();
    }

    interface OwnerData {//название турагенства
        String getUsername();
    }

}

