package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.Cliente;
import com.facilitoCRM.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable UUID id, @RequestBody Cliente entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
