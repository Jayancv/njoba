package com.portal.repository;

import com.portal.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, String> , JpaSpecificationExecutor<Advertisement> {

    List<Advertisement> findByUserAdvertisement_Id(String id);


}
