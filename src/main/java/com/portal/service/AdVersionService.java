package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.AdVersion;

public interface AdVersionService {
	List<AdVersion> getAll();
	List<AdVersion> getVersionByAdId(String id);
	AdVersion create(AdVersion obj);
	AdVersion getById(String id);
	AdVersion update(String id, AdVersion obj);
	AdVersion delete(String id, AdVersion obj);
	ResponseEntity<String> hardDelete(String id);
}
