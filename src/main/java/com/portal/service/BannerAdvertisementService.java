package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.BannerAdvertisement;

public interface BannerAdvertisementService {
	List<BannerAdvertisement> getAll();
	BannerAdvertisement create(BannerAdvertisement obj);
	BannerAdvertisement getById(String id);
	BannerAdvertisement update(String id, BannerAdvertisement obj);
	BannerAdvertisement delete(String id, BannerAdvertisement obj);
	ResponseEntity<String> hardDelete(String id);
}
