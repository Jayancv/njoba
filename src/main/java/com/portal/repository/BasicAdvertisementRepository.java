package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.BasicAdvertisement;

public interface BasicAdvertisementRepository extends JpaRepository <BasicAdvertisement, String> {

}
