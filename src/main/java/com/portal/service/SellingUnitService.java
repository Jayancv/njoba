package com.portal.service;


import com.portal.model.SellingUnit;

import java.util.List;

public interface SellingUnitService {
    List<SellingUnit> getAll();

    SellingUnit create(SellingUnit obj);

    SellingUnit getById(long id);
}
