package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.BasicAdvertisement;

public interface BasicAdvertisementService {
	List<BasicAdvertisement> getAll();
	BasicAdvertisement create(BasicAdvertisement obj);
	BasicAdvertisement getById(String id);
	BasicAdvertisement update(String id, BasicAdvertisement obj);
	BasicAdvertisement delete(String id, BasicAdvertisement obj);
	ResponseEntity<String> hardDelete(String id);
}
