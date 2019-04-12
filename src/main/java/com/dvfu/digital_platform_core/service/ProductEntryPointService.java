package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.ProductEntryPoint;

import java.util.List;

public interface ProductEntryPointService {

    List<ProductEntryPoint> findAll(Long productId);



}
