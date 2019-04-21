package com.dvfu.digital_platform_core.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_type")
    private ProjectType projectType;

    private String objective;

    @Column(length = 1000000)
    private String photoBefore;

    private String uniqueness;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    private Double totalFinancing;

    private Double currentFinancing;

    private Double minDonationSum;

    private Double implementationPeriod;

    @Enumerated(EnumType.STRING)
    private ProjectProgress projectProgress;

    @OneToMany(mappedBy = "takerProject")
    private List<Donation> donations;


    public Project() {
    }

    public Project(String title,
                   ProjectType projectType,
                   String objective,
                   String photoBefore,
                   String uniqueness,
                   User owner,
                   Double totalProjectFinancing,
                   Double currentFinancing,
                   Double minDonationSum,
                   Double implementationPeriod,
                   ProjectProgress projectProgress) {

        this.title = title;
        this.projectType = projectType;
        this.objective = objective;
        this.photoBefore = photoBefore;
        this.uniqueness = uniqueness;
        this.owner = owner;
        this.totalFinancing = totalProjectFinancing;
        this.currentFinancing = currentFinancing;
        this.minDonationSum = minDonationSum;
        this.implementationPeriod = implementationPeriod;
        this.projectProgress = projectProgress;
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

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
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

    public void setImplementationPeriod(Double implementationPeriod) {
        this.implementationPeriod = implementationPeriod;
    }

    public ProjectProgress getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(ProjectProgress projectProgress) {
        this.projectProgress = projectProgress;
    }
}
