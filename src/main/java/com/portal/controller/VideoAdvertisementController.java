package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.VideoAdvertisement;
import com.portal.service.VideoAdvertisementServiceImpl;

@RestController
@RequestMapping("/video-advertisement")
public class VideoAdvertisementController {

	@Autowired
	VideoAdvertisementServiceImpl videoAdvertisementServiceImpl;
	
	@GetMapping("/list")
	public List<VideoAdvertisement> getAll() {
	    return videoAdvertisementServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public VideoAdvertisement create(@Valid @RequestBody VideoAdvertisement obj) {
	    return videoAdvertisementServiceImpl.create(obj);
	}
	
}
