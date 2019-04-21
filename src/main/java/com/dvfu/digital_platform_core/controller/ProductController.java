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
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/spna/{ownerId}")
    @PreAuthorize("hasRole('SPNA')")
    public List<Product> getSPNAsProducts(@PathVariable Long ownerId) {
        return productService.findAll(ownerId);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('SPNA')")
    public Product insert(@RequestBody Product product) {
        return productService.insert(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SPNA')")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('SPNA')")
    public Product update(@RequestBody Product product) {
        return productService.update(product.getId(), product);
    }

}
