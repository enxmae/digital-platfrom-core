package com.dvfu.digital_platform_core.dao;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "projectType")
    private List<Project> projects;

    public ProjectType() {
    }

    public ProjectType(String title) {
        this.title = title;
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


}
