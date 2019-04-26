package com.dvfu.digital_platform_core.dao;

import java.util.List;

public interface TourCreateNote {

    String getTitle();

    List<ProductData> getProducts();

    OwnerData getOwner();

    interface ProductData{
        String getOriginalTitle();
    }

    interface OwnerData {//название турагенства
        String getUsername();
    }

}

