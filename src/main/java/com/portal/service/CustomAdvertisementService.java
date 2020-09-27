package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.CustomAdvertisement;

public interface CustomAdvertisementService {
	List<CustomAdvertisement> getAll();
	CustomAdvertisement create(CustomAdvertisement obj);
	CustomAdvertisement getById(String id);
	CustomAdvertisement update(String id, CustomAdvertisement obj);
	CustomAdvertisement delete(String id, CustomAdvertisement obj);
	ResponseEntity<String> hardDelete(String id);
}
