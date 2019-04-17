package com.dvfu.digital_platform_core.controller;

import com.dvfu.digital_platform_core.dao.Donation;
import com.dvfu.digital_platform_core.service.DonationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/donations")
public class DonationController {

    private final DonationService donationService;

    DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/{project_id}")
    @PreAuthorize("hasAnyRole('TOUR_OPERATOR', 'SPNA', 'TOURIST')")
    List<Donation> getTourOpearators(@PathVariable Long projectId) {
        return donationService.findAllTourOperatorByProjectId(projectId);
    }

    @PostMapping
    @PreAuthorize("hasRole('TOUR_OPERATOR')")
    Donation insert(@RequestBody Donation donation) {
        return donationService.insert(donation);
    }

}
