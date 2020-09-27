package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.CustomAdvertisement;
import com.portal.service.CustomAdvertisementServiceImpl;

@RestController
@RequestMapping("/custom-advertisement")
public class CustomAdvertisementController {

	@Autowired
	CustomAdvertisementServiceImpl customAdvertisementServiceImpl;
	
	@GetMapping("/list")
	public List<CustomAdvertisement> getAll() {
	    return customAdvertisementServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public CustomAdvertisement create(@Valid @RequestBody CustomAdvertisement obj) {
	    return customAdvertisementServiceImpl.create(obj);
	}
}
