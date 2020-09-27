package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.VideoAdvertisement;

public interface VideoAdvertisementService {
	List<VideoAdvertisement> getAll();
	VideoAdvertisement create(VideoAdvertisement obj);
	VideoAdvertisement getById(String id);
	VideoAdvertisement update(String id, VideoAdvertisement obj);
	VideoAdvertisement delete(String id, VideoAdvertisement obj);
	ResponseEntity<String> hardDelete(String id);
}
