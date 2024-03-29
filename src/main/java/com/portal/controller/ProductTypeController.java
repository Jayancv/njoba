package com.portal.controller;

import com.portal.model.ProductType;
import com.portal.service.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @GetMapping("/product-list")
    public List<ProductType> getAll() {
        return productTypeService.getAll();
    }

    @PostMapping("/create")
    public ProductType create(@Valid @RequestBody ProductType productType) {
        return productTypeService.create(productType);
    }

    @GetMapping("/{id}")
    public ProductType getById(@PathVariable(value = "id") long id) {
        return productTypeService.getById(id);
    }

    @PutMapping("/increase-unit-count/{id}")
    public int update(@PathVariable(value = "id") long id, @Valid @RequestBody int count) {
        return productTypeService.setSellingUnitCount(id, count, true);
    }

    @PutMapping("/update-unit-price/{id}")
    public double update(@PathVariable(value = "id") long id, @Valid @RequestBody double price) {
        return productTypeService.setSellingUnitPrice(id, price);
    }
}
