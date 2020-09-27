package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.model.VideoAdvertisement;
import com.portal.repository.VideoAdvertisementRepository;

@Service
public class VideoAdvertisementServiceImpl implements VideoAdvertisementService{
	
	@Autowired
	 VideoAdvertisementRepository videoAdvertisementRepository;

	@Autowired
	ProductTypeService productTypeService;
	
	@Override
	public List<VideoAdvertisement> getAll() {
		return videoAdvertisementRepository.findAll();
	}

	@Override
	public VideoAdvertisement create(VideoAdvertisement obj) {
		/**
		 * Reduce selling units
		 * If success then save the advertisement
		 */

		if (obj.getProductType() != null && productTypeService.reduceUnitCount(obj.getProductType().getId(), 1)) {
			return videoAdvertisementRepository.save(obj);
		}
		return null;
	}

	@Override
	public VideoAdvertisement getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoAdvertisement update(String id, VideoAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoAdvertisement delete(String id, VideoAdvertisement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
