package com.dvfu.digital_platform_core.controller;

import com.dvfu.digital_platform_core.dao.Product;
import com.dvfu.digital_platform_core.dao.ProductEntryPoint;
import com.dvfu.digital_platform_core.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/products")
@PreAuthorize("hasRole('SPNA')")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/spna/{spna_id}")
    public List<Product> getAll(@PathVariable Long spna_id) {
        return productService.findAll(spna_id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product insert(@RequestBody Product product) {
        return productService.insert(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product.getId(), product);
    }

}
