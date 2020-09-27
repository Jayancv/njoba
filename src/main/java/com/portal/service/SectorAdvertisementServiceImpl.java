package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.model.SectorAdvertisement;
import com.portal.repository.SectorAdvertisementRepository;

@Service
public class SectorAdvertisementServiceImpl implements SectorAdvertisementService {

	@Autowired
	SectorAdvertisementRepository sectorAdvertisementRepository;

	@Autowired
	ProductTypeService productTypeService;
	
	@Override
	public List<SectorAdvertisement> getAll() {
		return sectorAdvertisementRepository.findAll();
	}

	@Override
	public SectorAdvertisement create(SectorAdvertisement obj) {
		/**
		 * Reduce selling units
		 * If success then save the advertisement
		 */

		if (obj.getProductType() != null && productTypeService.reduceUnitCount(obj.getProductType().getId(), 1)) {
			return sectorAdvertisementRepository.save(obj);
		}
		return null;
	}

	@Override
	public SectorAdvertisement getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorAdvertisement update(String id, SectorAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorAdvertisement delete(String id, SectorAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
