package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.dto.QuoteDTO;
import com.facilitoCRM.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "http://localhost:8081")
public class QuoteController {

    @Autowired
    private QuoteService service;

    @GetMapping("/lead/{leadId}")
    public List<QuoteDTO> findAllByLeadId(@PathVariable UUID leadId) {
        return service.findAllByLeadId(leadId);
    }

    @PostMapping
    public QuoteDTO create(@RequestBody QuoteDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public QuoteDTO update(@PathVariable UUID id, @RequestBody QuoteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
