package com.dvfu.digital_platform_core.dao;


import com.dvfu.digital_platform_core.constants.TourProgress;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Tour implements Serializable {

    private static final long serialVersionUID = -6173672801831223096L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "tour")
    private List<TourProduct> tourProducts;

    @Enumerated(EnumType.STRING)
    private TourProgress tourProgress;


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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TourProgress getTourProgress() {
        return tourProgress;
    }

    public void setTourProgress(TourProgress tourProgress) {
        this.tourProgress = tourProgress;
    }
}
