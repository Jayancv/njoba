package com.portal.repository;

import com.portal.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    List<ProductType> findBySouvenir_Id(long id);
    List<ProductType> findByAdvertisementType_Id(long id);
}
