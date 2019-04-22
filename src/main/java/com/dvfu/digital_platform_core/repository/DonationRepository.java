package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findAllByTakerProject_Id(Long projectId);

}
