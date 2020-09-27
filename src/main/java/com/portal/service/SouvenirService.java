package com.portal.service;

import com.portal.model.Souvenir;

import java.util.List;

public interface SouvenirService {

    List<Souvenir> getAll();

    Souvenir create(Souvenir obj);

    Souvenir getById(long id);
}
