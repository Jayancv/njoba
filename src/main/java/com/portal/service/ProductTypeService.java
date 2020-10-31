package com.portal.service;


import com.portal.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAll();

    ProductType create(ProductType obj);

    ProductType getById(long id);

    /**
     * This method uses to check remaining unit count
     *
     * @param productId Product type id
     * @param count     Number of units need to reduct
     * @return Unit availability Status (Success or Fail)
     */
    boolean checkUnitAvail(long productId, int count);

    /**
     * This method uses to reduct remaining unit count
     *
     * @param productId Product type id
     * @param count     Number of units need to reduct
     * @return Operation Status (Success or Fail)
     */
    boolean reduceUnitCount(long productId, int count);

    /**
     * This method uses to revert reduced remaining unit if AD was not succeeded
     *
     * @param productId Product type id
     * @param count     Number of units need to revert back
     * @return Operation Status (Success or Fail)
     */
    boolean revertUnitCount(long productId, int count);

    /**
     * This method uses to increase sold selling unit count after successfully saving AD
     *
     * @param productId Product type id
     * @param count     Number of units need to up
     * @return Operation Status (Success or Fail)
     */
    boolean upSoldUnitCount(long productId, int count);

     /**
     * This method uses to set selling units (Remaining count)
     *
     * @param productId
     * @param count
     * @return new remaining unit count
     */
    int setSellingUnitCount(long productId, int count, boolean add);


    /**
     * This method uses to update price of given sellong unit
     *
     * @param productId
     * @param price
     * @return current price
     */
    double setSellingUnitPrice(long productId, double price);
}
