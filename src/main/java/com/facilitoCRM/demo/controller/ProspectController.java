package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.Prospect;
import com.facilitoCRM.demo.repository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prospects")
public class ProspectController {

    @Autowired
    private ProspectRepository repository;

    @GetMapping
    public List<Prospect> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Prospect findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Prospect create(@RequestBody Prospect entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public Prospect update(@PathVariable UUID id, @RequestBody Prospect entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
