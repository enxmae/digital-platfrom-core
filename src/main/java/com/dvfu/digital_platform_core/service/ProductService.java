package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(Long id);

    List<Product> findAll();

    Product findById(Long id);

    Product insert(Product product);

    void delete(Long productId);

    Product update(Long id, Product product);

}
