package com.portal.service;


import com.portal.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAll();

    ProductType create(ProductType obj);

    ProductType getById(long id);

    /**
     * This method uses to reduct remaining unit count
     *
     * @param productId Product type id
     * @param count     Number of units need to reduct
     * @return Operation Status (Success or Fail)
     */
    boolean reduceUnitCount(long productId, int count);
}
