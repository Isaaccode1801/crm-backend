package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.dto.ProviderDTO;
import com.facilitoCRM.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/providers")
@CrossOrigin(origins = "http://localhost:8081")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @GetMapping
    public List<ProviderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProviderDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }
    
    // Note: Provider is read-only, no POST, PUT, DELETE methods
}
