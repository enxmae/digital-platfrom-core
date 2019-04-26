package com.dvfu.digital_platform_core.dao;

import com.dvfu.digital_platform_core.constants.ProjectProgress;
import com.dvfu.digital_platform_core.constants.Project2ProductMode;
import com.dvfu.digital_platform_core.constants.ProjectVotingPrivateLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type;

    private String objective;

    @Column(length = 1000000)
    private String photoBefore;

    private String uniqueness;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    private Double totalFinancing;

    private Double currentFinancing = 0.0;

    private Double minDonationSum;

    private Double implementationPeriod;

    private Integer donationAmount = 0;

    @Enumerated(EnumType.STRING)
    private Project2ProductMode project2ProductMode;

    @Enumerated(EnumType.STRING)
    private ProjectProgress projectProgress;

    @Enumerated(EnumType.STRING)
    private ProjectVotingPrivateLevel votingPrivateLevel;

    @OneToMany(mappedBy = "takerProject")
    private List<Donation> donations;


    public Project() {
    }

    public Project(String title,
                   String type,
                   String objective,
                   String photoBefore,
                   String uniqueness,
                   User owner,
                   Double totalProjectFinancing,
                   Double currentFinancing,
                   Double minDonationSum,
                   Double implementationPeriod,
                   ProjectProgress projectProgress,
                   Project2ProductMode project2ProductMode,
                   ProjectVotingPrivateLevel votingPrivateLevel) {

        this.title = title;
        this.type = type;
        this.objective = objective;
        this.photoBefore = photoBefore;
        this.uniqueness = uniqueness;
        this.owner = owner;
        this.totalFinancing = totalProjectFinancing;
        this.currentFinancing = currentFinancing;
        this.minDonationSum = minDonationSum;
        this.implementationPeriod = implementationPeriod;
        this.projectProgress = projectProgress;
        this.project2ProductMode = project2ProductMode;
        this.votingPrivateLevel = votingPrivateLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPhotoBefore() {
        return photoBefore;
    }

    public void setPhotoBefore(String photoBefore) {
        this.photoBefore = photoBefore;
    }

    public String getUniqueness() {
        return uniqueness;
    }

    public void setUniqueness(String uniqueness) {
        this.uniqueness = uniqueness;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getTotalFinancing() {
        return totalFinancing;
    }

    public void setTotalFinancing(Double totalFinancing) {
        this.totalFinancing = totalFinancing;
    }

    public Double getCurrentFinancing() {
        return currentFinancing;
    }

    public void setCurrentFinancing(Double currentFinancing) {
        this.currentFinancing = currentFinancing;
    }

    public Double getMinDonationSum() {
        return minDonationSum;
    }

    public void setMinDonationSum(Double minDonationSum) {
        this.minDonationSum = minDonationSum;
    }

    public Double getImplementationPeriod() {
        return implementationPeriod;
    }

    public Integer getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Integer donationAmount) {
        this.donationAmount = donationAmount;
    }

    public void setImplementationPeriod(Double implementationPeriod) {
        this.implementationPeriod = implementationPeriod;
    }

    public ProjectProgress getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(ProjectProgress projectProgress) {
        this.projectProgress = projectProgress;
    }

    public Project2ProductMode getProject2ProductMode() {
        return project2ProductMode;
    }

    public void setProject2ProductMode(Project2ProductMode project2ProductMode) {
        this.project2ProductMode = project2ProductMode;
    }

    public ProjectVotingPrivateLevel getVotingPrivateLevel() {
        return votingPrivateLevel;
    }

    public void setVotingPrivateLevel(ProjectVotingPrivateLevel votingPrivateLevel) {
        this.votingPrivateLevel = votingPrivateLevel;
    }
}
