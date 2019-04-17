package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Donation;

import java.util.List;

public interface DonationService {
    
    Donation insert(Donation donation);

    List<Donation> findAllTourOperatorByProjectId(Long projectId);
}
