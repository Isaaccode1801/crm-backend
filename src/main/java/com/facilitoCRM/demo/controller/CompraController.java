package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.Compra;
import com.facilitoCRM.demo.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "http://localhost:8081")
public class CompraController {

    @Autowired
    private CompraRepository repository;

    @GetMapping
    public List<Compra> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Compra findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Compra create(@RequestBody Compra entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public Compra update(@PathVariable UUID id, @RequestBody Compra entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
