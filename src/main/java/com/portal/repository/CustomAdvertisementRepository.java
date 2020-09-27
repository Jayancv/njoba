package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.CustomAdvertisement;

public interface CustomAdvertisementRepository extends JpaRepository <CustomAdvertisement, String> {

}
