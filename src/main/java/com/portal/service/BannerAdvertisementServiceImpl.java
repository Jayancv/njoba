package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.model.BannerAdvertisement;
import com.portal.repository.BannerAdvertisementRepository;

@Service
public class BannerAdvertisementServiceImpl implements BannerAdvertisementService {
	
	
	@Autowired
	BannerAdvertisementRepository bannerAdvertisementRepository;

	@Autowired
	ProductTypeService productTypeService;


	@Override
	public List<BannerAdvertisement> getAll() {
		return bannerAdvertisementRepository.findAll();
	}

	@Override
	public BannerAdvertisement create(BannerAdvertisement obj) {
		/**
		 * Reduce selling units
		 * If success then save the advertisement
		 */

		if (obj.getProductType() != null && productTypeService.reduceUnitCount(obj.getProductType().getId(), 1)) {
			return bannerAdvertisementRepository.save(obj);
		}
		return null;
	}

	@Override
	public BannerAdvertisement getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BannerAdvertisement update(String id, BannerAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BannerAdvertisement delete(String id, BannerAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
