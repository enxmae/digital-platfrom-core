package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOwner_Id(Long id);

}
