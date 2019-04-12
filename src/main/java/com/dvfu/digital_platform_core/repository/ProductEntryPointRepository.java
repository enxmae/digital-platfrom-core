package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.ProductEntryPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductEntryPointRepository extends JpaRepository<ProductEntryPoint, Long> {

    List<ProductEntryPoint> findProductEntryPoint_EntryPointByProduct_Id(Long id);

}
