package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.constants.TourProgress;
import com.dvfu.digital_platform_core.dao.TourCreateNotification;
import com.dvfu.digital_platform_core.dao.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
//    @Query("SELECT title, owner.id FROM Tour WHERE id = :id")
//    List<Tour> findTitleTest(@Param("id") Long id);

    //List<TourCreateNotification> findToursByProducts_Owner_Id(Long productsOwnerId);//статус неодобрен

    Tour findTourById(Long id);

    List<Tour> findAllByOwner_Id(Long id);

    List<Tour> findAllByTourProgress(TourProgress tourProgress);

}
