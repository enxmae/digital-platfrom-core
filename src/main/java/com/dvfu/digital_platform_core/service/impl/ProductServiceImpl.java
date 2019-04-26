package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.repository.ProductRepository;
import com.dvfu.digital_platform_core.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(Long id) {
        return productRepository.findAllByOwner_Id(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Long id, Product product) {
        Product productFromDB = findById(id);

        BeanUtils.copyProperties(product, productFromDB, "id");

        return productRepository.save(productFromDB);
    }

    @Override
    public List<Product> findTest(String originalTitle, Integer anthopogenLoad) {
        return productRepository.findAllByOriginalTitleAndAnthropogenicLoad(originalTitle, anthopogenLoad);
    }
}
