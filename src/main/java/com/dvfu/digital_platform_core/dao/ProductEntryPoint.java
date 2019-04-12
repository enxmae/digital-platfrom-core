package com.dvfu.digital_platform_core.dao;

import javax.persistence.*;

@Entity
@Table
public class ProductEntryPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entry_point_id")
    private EntryPoint entryPoint;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductEntryPoint() {

    }

    public ProductEntryPoint(EntryPoint entryPoint, Product product) {
        this.entryPoint = entryPoint;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntryPoint getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
