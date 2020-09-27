package com.portal.service;

import com.portal.model.SellingUnit;
import com.portal.repository.SellingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellingUnitServiceImpl implements SellingUnitService {

    @Autowired
    SellingUnitRepository sellingUnitRepository;

    @Override
    public List<SellingUnit> getAll() {
        return sellingUnitRepository.findAll();
    }

    @Override
    public SellingUnit create(SellingUnit obj) {
        return sellingUnitRepository.save(obj);
    }

    @Override
    public SellingUnit getById(long id) {
        return null;
    }
}
