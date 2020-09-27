package com.portal.service;

import com.portal.model.AdvertisementType;

import java.util.List;

public interface AdvertisementTypeService {
    List<AdvertisementType> getAll();

    AdvertisementType create(AdvertisementType obj);

    AdvertisementType getById(long id);
}
