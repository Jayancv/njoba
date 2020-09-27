package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.AdVersion;

import java.util.List;

public interface AdVersionRepository extends JpaRepository <AdVersion, String> {

    List<AdVersion> findByAdvertisement_Id(String id);

}
