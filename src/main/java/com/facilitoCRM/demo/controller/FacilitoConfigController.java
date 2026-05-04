package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.FacilitoConfig;
import com.facilitoCRM.demo.repository.FacilitoConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/config")
public class FacilitoConfigController {

    @Autowired
    private FacilitoConfigRepository repository;

    @GetMapping
    public List<FacilitoConfig> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public FacilitoConfig findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public FacilitoConfig create(@RequestBody FacilitoConfig entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public FacilitoConfig update(@PathVariable UUID id, @RequestBody FacilitoConfig entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
