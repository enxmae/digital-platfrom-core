package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.ProductEntryPoint;
import com.dvfu.digital_platform_core.repository.ProductEntryPointRepository;
import com.dvfu.digital_platform_core.service.ProductEntryPointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEntryPointServiceImpl implements ProductEntryPointService {

    private static ProductEntryPointRepository productEntryPointRepository;

    public ProductEntryPointServiceImpl(ProductEntryPointRepository productEntryPointRepository) {
        this.productEntryPointRepository = productEntryPointRepository;

    }

    @Override
    public List<ProductEntryPoint> findAll(Long productId) {
        return productEntryPointRepository.findProductEntryPoint_EntryPointByProduct_Id(productId);
    }
}
