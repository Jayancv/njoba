package com.portal.service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.ProductType;
import com.portal.model.SellingUnit;
import com.portal.repository.ProductTypeRepository;
import com.portal.repository.SellingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    SellingUnitRepository sellingUnitRepository;

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType create(ProductType obj) {
        return productTypeRepository.save(obj);
    }

    @Override
    public ProductType getById(long id) {
        return productTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    @Override
    public boolean reduceUnitCount(long id, int count) {
        if ( this.getById(id) != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            if (sellingUnit.getRemainCount() >= count) {  //Check availability
                sellingUnit.setRemainCount(sellingUnit.getRemainCount() - count);
                sellingUnitRepository.save(sellingUnit);
                return true;
            }
        }
        return false;
    }
}
