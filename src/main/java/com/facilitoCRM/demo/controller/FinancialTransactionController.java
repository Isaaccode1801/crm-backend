package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.FinancialTransaction;
import com.facilitoCRM.demo.repository.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/financial-transactions")
@CrossOrigin(origins = "http://localhost:8081")
public class FinancialTransactionController {

    @Autowired
    private FinancialTransactionRepository repository;

    @GetMapping
    public List<FinancialTransaction> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public FinancialTransaction findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public FinancialTransaction create(@RequestBody FinancialTransaction entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public FinancialTransaction update(@PathVariable UUID id, @RequestBody FinancialTransaction entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
