package com.portal.service;

import com.portal.model.AdvertisementType;
import com.portal.repository.AdvertisementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementTypeServiceImpl implements AdvertisementTypeService {

    @Autowired
    AdvertisementTypeRepository advertisementTypeRepository;

    @Override
    public List<AdvertisementType> getAll() {
        return advertisementTypeRepository.findAll();
    }

    @Override
    public AdvertisementType create(AdvertisementType obj) {
        return advertisementTypeRepository.save(obj);
    }

    @Override
    public AdvertisementType getById(long id) {
        return null;
    }
}
