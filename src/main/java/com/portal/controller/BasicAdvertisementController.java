package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.BasicAdvertisement;
import com.portal.service.BasicAdvertisementServiceImpl;

@RestController
@RequestMapping("/basic-advertisement")
public class BasicAdvertisementController {

    @Autowired
    BasicAdvertisementServiceImpl basicAdvertisementServiceImpl;

    @GetMapping("/list")
    public List<BasicAdvertisement> getAll() {
        return basicAdvertisementServiceImpl.getAll();
    } 
    
    @PostMapping("/create")
    public BasicAdvertisement create(@Valid @RequestBody BasicAdvertisement ad) {
        return basicAdvertisementServiceImpl.create(ad);
    }

    @GetMapping("/{id}")
    public BasicAdvertisement getById(@PathVariable(value = "id") String id) {
        return basicAdvertisementServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public BasicAdvertisement update(@PathVariable(value = "id") String id, @Valid @RequestBody BasicAdvertisement advertisement) {
        return basicAdvertisementServiceImpl.update(id, advertisement);
    }

    @PutMapping("/deactivate/{id}")
    public BasicAdvertisement delete(@PathVariable(value = "id") String id , @Valid @RequestBody BasicAdvertisement advertisement) {
        return basicAdvertisementServiceImpl.delete(id, advertisement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hardDelete(@PathVariable(value = "id") String id ) {
        return basicAdvertisementServiceImpl.hardDelete(id);
    }
}
