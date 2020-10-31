package com.portal.service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.ProductType;
import com.portal.model.SellingUnit;
import com.portal.repository.ProductTypeRepository;
import com.portal.repository.SellingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean checkUnitAvail(long id, int count) {
        if (this.getById(id) != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            //Check availability
            return sellingUnit.getRemainCount() >= count;
        }
        return false;
    }

    @Override
    public boolean reduceUnitCount(long id, int count) {
        if (this.getById(id) != null && this.getById(id).getSellingUnit() != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            if (sellingUnit.getRemainCount() >= count) {  //Check availability
                sellingUnit.setRemainCount(sellingUnit.getRemainCount() - count);
                sellingUnitRepository.save(sellingUnit);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean revertUnitCount(long id, int count) {
        if (this.getById(id) != null && this.getById(id).getSellingUnit() != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            sellingUnit.setRemainCount(sellingUnit.getRemainCount() + count);
            sellingUnitRepository.save(sellingUnit);
            return true;

        }
        return false;
    }

    @Override
    public boolean upSoldUnitCount(long id, int count) {
        if (this.getById(id) != null && this.getById(id).getSellingUnit() != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            sellingUnit.setSoldCount(sellingUnit.getSoldCount() + count);
            sellingUnitRepository.save(sellingUnit);
            return true;

        }
        return false;
    }

    @Override
    public int setSellingUnitCount(long id, int count, boolean add) {
        if (this.getById(id) != null && this.getById(id).getSellingUnit() != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            if (add) {
                count = count + sellingUnit.getRemainCount();
            }
            sellingUnit.setRemainCount(count);
            sellingUnit.setUnits(count + sellingUnit.getSoldCount());
            sellingUnitRepository.save(sellingUnit);
            return count;

        }
        return -1;
    }

    @Override
    public double setSellingUnitPrice(long id, double price) {
        if (this.getById(id) != null && this.getById(id).getSellingUnit() != null) {
            SellingUnit sellingUnit = this.getById(id).getSellingUnit();
            sellingUnit.setPrice(price);
            sellingUnitRepository.save(sellingUnit);
            return price;

        }
        return -1;
    }
}
