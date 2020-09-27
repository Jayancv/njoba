package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.SectorAdvertisement;
import com.portal.service.SectorAdvertisementServiceImpl;

@RestController
@RequestMapping("/sector-advertisement")
public class SectorAdvertisementController {

	@Autowired
	SectorAdvertisementServiceImpl sectorAdvertisementServiceImpl;
	
	@GetMapping("/list")
	public List<SectorAdvertisement> getAll() {
	    return sectorAdvertisementServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public SectorAdvertisement create(@Valid @RequestBody SectorAdvertisement obj) {
	    return sectorAdvertisementServiceImpl.create(obj);
	}
	
}
