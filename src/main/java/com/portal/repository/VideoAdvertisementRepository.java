package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.VideoAdvertisement;

public interface VideoAdvertisementRepository extends JpaRepository <VideoAdvertisement, String> {

}
