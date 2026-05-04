package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.dto.LeadDTO;
import com.facilitoCRM.demo.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "http://localhost:8081")
public class LeadController {

    @Autowired
    private LeadService service;

    @GetMapping
    public Page<LeadDTO> findAll(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String stage,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return service.findAllPaged(search, stage, PageRequest.of(page, size, Sort.by("nome").ascending()));
    }

    @GetMapping("/{id}")
    public LeadDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public LeadDTO create(@RequestBody LeadDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public LeadDTO update(@PathVariable UUID id, @RequestBody LeadDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
