package com.portal.service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.Souvenir;
import com.portal.repository.SouvenirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SouvenirServiceImpl implements SouvenirService {

    @Autowired
    SouvenirRepository souvenirRepository;

    @Override
    public List<Souvenir> getAll() {
        return souvenirRepository.findAll();
    }

    @Override
    public Souvenir create(Souvenir obj) {
        return souvenirRepository.save(obj);
    }

    @Override
    public Souvenir getById(long id) {
        return souvenirRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }
}
