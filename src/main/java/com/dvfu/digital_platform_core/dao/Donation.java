package com.dvfu.digital_platform_core.dao;

import javax.persistence.*;

@Entity
@Table
public class Donation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taker_project_id")
    private Project takerProject;

    @OneToOne
    @JoinColumn(name = "donater_user_id")
    private User donaterUser;

    private Double donationMoneyAmount;

    public Donation() {
    }

    public Donation(Project takerProject,
                    User donaterUser,
                    Double donationMoneyAmount) {

        this.takerProject = takerProject;
        this.donaterUser = donaterUser;
        this.donationMoneyAmount = donationMoneyAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getTakerProduct() {
        return takerProject;
    }

    public void setTakerProduct(Project takerProject) {
        this.takerProject = takerProject;
    }

    public User getDonaterUser() {
        return donaterUser;
    }

    public void setDonaterUser(User donaterUser) {
        this.donaterUser = donaterUser;
    }

    public Double getDonationMoneyAmount() {
        return donationMoneyAmount;
    }

    public void setDonationMoneyAmount(Double donationMoneyAmount) {
        this.donationMoneyAmount = donationMoneyAmount;
    }

}
