package com.dvfu.digital_platform_core.dao;

import com.dvfu.digital_platform_core.constants.TourProgress;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class TourProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private TourProgress tourProgress;

    public TourProduct() {
    }

    public TourProduct(Tour tour, Product product, TourProgress tourProgress) {
        this.tour = tour;
        this.product = product;
        this.tourProgress = tourProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public TourProgress getTourProgress() {
        return tourProgress;
    }

    public void setTourProgress(TourProgress tourProgress) {
        this.tourProgress = tourProgress;
    }
}
