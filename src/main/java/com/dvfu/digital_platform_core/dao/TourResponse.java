package com.dvfu.digital_platform_core.dao;

import com.dvfu.digital_platform_core.constants.TourProgress;

import java.util.List;

public class TourResponse {

    private Long id;

    private List<ToursProducts> products;

    private String title;

    private String description;

    private User owner;

    private TourProgress tourProgress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ToursProducts> getProducts() {
        return products;
    }

    public void setProducts(List<ToursProducts> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public TourProgress getTourProgress() {
        return tourProgress;
    }

    public void setTourProgress(TourProgress tourProgress) {
        this.tourProgress = tourProgress;
    }

}
