package com.dvfu.digital_platform_core.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class EntryPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "entryPoint")
    private List<ProductEntryPoint> productEntryPoints;

    public EntryPoint() {
    }

    public EntryPoint(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
