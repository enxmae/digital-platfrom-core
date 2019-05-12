package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.TourCreateNotification;
import com.dvfu.digital_platform_core.dao.TourProduct;
import com.dvfu.digital_platform_core.dao.ToursProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourProductRepository extends JpaRepository<TourProduct, Long> {

    List<ToursProducts> findAllByTour_Id(Long tourId); //find all products for tour

    TourProduct findByTour_IdAndProduct_Id(Long tourId, Long productId);

    List<TourCreateNotification> findAllTourProductByTour_Id(Long tourId);

}
