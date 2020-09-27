package com.portal.service;

import java.util.List;

import com.portal.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.model.AdVersion;
import com.portal.repository.AdVersionRepository;

@Service
public class AdVersionServiceImpl implements AdVersionService {
	
	@Autowired
	AdVersionRepository adVersionRepository;

	@Override
	public List<AdVersion> getAll() {
		return adVersionRepository.findAll();
	}

	@Override
	public List<AdVersion> getVersionByAdId(String id) {
		return adVersionRepository.findByAdvertisement_Id(id);
	}

	@Override
	public AdVersion create(AdVersion obj) {
		return adVersionRepository.save(obj);
	}

	@Override
	public AdVersion getById(String id) {
		return adVersionRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public AdVersion update(String id, AdVersion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdVersion delete(String id, AdVersion obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
