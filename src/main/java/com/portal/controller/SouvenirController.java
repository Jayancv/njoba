package com.portal.controller;

import com.portal.model.Souvenir;
import com.portal.service.SouvenirServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/souvenir")
public class SouvenirController {
    @Autowired
    SouvenirServiceImpl souvenirService;

    @GetMapping("/souvenir-list")
    public List<Souvenir> getAll() {
        return souvenirService.getAll();
    }

    @PostMapping("/create")
    public Souvenir create(@Valid @RequestBody Souvenir souvenir) {
        return souvenirService.create(souvenir);
    }

    @GetMapping("/{id}")
    public Souvenir getById(@PathVariable(value = "id") long id) {
        return souvenirService.getById(id);
    }


}
