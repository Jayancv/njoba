package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.BannerAdvertisement;
import com.portal.service.BannerAdvertisementServiceImpl;

@RestController
@RequestMapping("/banner-advertisement")
public class BannerAdvertisementController {
	
	@Autowired
	BannerAdvertisementServiceImpl bannerAdvertisementServiceImpl;
	
	@GetMapping("/list")
	public List<BannerAdvertisement> getAll() {
	    return bannerAdvertisementServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public BannerAdvertisement create(@Valid @RequestBody BannerAdvertisement obj) {
	    return bannerAdvertisementServiceImpl.create(obj);
	}
}
