package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.model.CustomAdvertisement;
import com.portal.repository.CustomAdvertisementRepository;

@Service
public class CustomAdvertisementServiceImpl implements CustomAdvertisementService {
	
	@Autowired
	CustomAdvertisementRepository customAdvertisementRepository;

	@Autowired
	ProductTypeService productTypeService;

	@Override
	public List<CustomAdvertisement> getAll() {
		return customAdvertisementRepository.findAll();
	}

	@Override
	public CustomAdvertisement create(CustomAdvertisement obj) {
		/**
		 * Reduce selling units
		 * If success then save the advertisement
		 */

		if (obj.getProductType() != null && productTypeService.reduceUnitCount(obj.getProductType().getId(), 1)) {
			return customAdvertisementRepository.save(obj);
		}
		return null;
	}

	@Override
	public CustomAdvertisement getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomAdvertisement update(String id, CustomAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomAdvertisement delete(String id, CustomAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
