package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.SectorAdvertisement;

public interface SectorAdvertisementService {
	List<SectorAdvertisement> getAll();
	SectorAdvertisement create(SectorAdvertisement obj);
	SectorAdvertisement getById(String id);
	SectorAdvertisement update(String id, SectorAdvertisement obj);
	SectorAdvertisement delete(String id, SectorAdvertisement obj);
	ResponseEntity<String> hardDelete(String id);
}
