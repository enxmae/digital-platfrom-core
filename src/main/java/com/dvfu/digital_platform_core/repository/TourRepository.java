package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.Note;
import com.dvfu.digital_platform_core.dao.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {


    @Query("SELECT title, owner.id FROM Tour WHERE id = :id")
    List<Tour> findTitleTest(@Param("id") Long id);

    Note findTourById(Long id);
}
