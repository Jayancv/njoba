package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portal.model.AdVersion;
import com.portal.service.AdVersionServiceImpl;

@RestController
@RequestMapping("/ad-version")
public class AdVersionController {

    @Autowired
    AdVersionServiceImpl adVersionServiceImpl;

    @GetMapping("/list")
    public List<AdVersion> getAll() {
        return adVersionServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public AdVersion getById(@PathVariable(value = "id") String id) {
        return adVersionServiceImpl.getById(id);
    }

    @GetMapping("/ad/{adId}")
    public List<AdVersion> getByAdId(@PathVariable(value = "adId") String adId) {
        return adVersionServiceImpl.getVersionByAdId(adId);
    }

    @PostMapping("/create")
    public AdVersion create(@Valid @RequestBody AdVersion obj) {
        return adVersionServiceImpl.create(obj);
    }

}
