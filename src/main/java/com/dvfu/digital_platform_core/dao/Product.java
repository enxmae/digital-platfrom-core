package com.dvfu.digital_platform_core.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Product implements Serializable {

    private static final long serialVersionUID = -6173672801831223096L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String originalTitle;

    @Column(length = 1000000)
    private String photo;

    private String location;

    private String isSleepPossible;

    private String sleepPlaceDescription;

    private String productDescription;

    private String popularLevel;

    private String mandatoryServices;

    private String extraServices;

    private Integer anthropogenicLoad;

    @OneToMany(mappedBy = "product")
    private List<ProductEntryPoint> productEntryPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "product")
    private List<TourProduct> tourProducts;

    public Product() {
    }

    public Product(String type,
                   String originalTitle,
                   String photo, String location,
                   String isSleepPossible,
                   String sleepPlaceDescription,
                   String productDescription,
                   String popularLevel,
                   String mandatoryServices,
                   String extraServices,
                   Integer anthropogenicLoad,
                   User owner) {

        this.type = type;
        this.originalTitle = originalTitle;
        this.photo = photo;
        this.location = location;
        this.isSleepPossible = isSleepPossible;
        this.sleepPlaceDescription = sleepPlaceDescription;
        this.productDescription = productDescription;
        this.popularLevel = popularLevel;
        this.mandatoryServices = mandatoryServices;
        this.extraServices = extraServices;
        this.anthropogenicLoad = anthropogenicLoad;
        this.owner = owner;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsSleepPossible() {
        return isSleepPossible;
    }

    public void setIsSleepPossible(String sleepPossible) {
        isSleepPossible = sleepPossible;
    }

    public String getSleepPlaceDescription() {
        return sleepPlaceDescription;
    }

    public void setSleepPlaceDescription(String sleepPlaceDescription) {
        this.sleepPlaceDescription = sleepPlaceDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public String getPopularLevel() {
        return popularLevel;
    }

    public void setPopularLevel(String popularLevel) {
        this.popularLevel = popularLevel;
    }

    public String getMandatoryServices() {
        return mandatoryServices;
    }

    public void setMandatoryServices(String mandatoryServices) {
        this.mandatoryServices = mandatoryServices;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    public Integer getAnthropogenicLoad() {
        return anthropogenicLoad;
    }

    public void setAnthropogenicLoad(Integer anthropogenicLoad) {
        this.anthropogenicLoad = anthropogenicLoad;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
