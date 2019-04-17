package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Donation;
import com.dvfu.digital_platform_core.repository.DonationRepository;
import com.dvfu.digital_platform_core.service.DonationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Donation insert(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> findAllTourOperatorByProjectId(Long projectId) {
        return donationRepository.findAllByTakerProject_Id(projectId);
    }
}
