package com.dvfu.digital_platform_core.controller;

import com.dvfu.digital_platform_core.dao.EntryPoint;
import com.dvfu.digital_platform_core.dao.ProductEntryPoint;
import com.dvfu.digital_platform_core.service.EntryPointService;
import com.dvfu.digital_platform_core.service.ProductEntryPointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products/{id}/entry_points")
public class EntryPointController {

    private final EntryPointService entryPointService;
    private final ProductEntryPointService productEntryPointService;

    public EntryPointController(EntryPointService entryPointService, ProductEntryPointService productEntryPointService) {
        this.entryPointService = entryPointService;
        this.productEntryPointService = productEntryPointService;
    }

    @GetMapping
    public List<ProductEntryPoint> getAllByProductId() {
        return productEntryPointService.findAll(1L);
    }

    /*@GetMapping("/{id}")
    public EntryPoint getEntryPointById(Long id) {
        return entryPointService.findById(id);
    }*/

    @PostMapping
    public EntryPoint insert(@RequestBody EntryPoint entryPoint) {
        return entryPointService.insert(entryPoint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entryPointService.delete(id);
    }

}
