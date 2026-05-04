package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.dto.NotaFiscalDTO;
import com.facilitoCRM.demo.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notas-fiscais")
@CrossOrigin(origins = "http://localhost:8081")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @GetMapping("/lead/{leadId}")
    public List<NotaFiscalDTO> findAllByLeadId(@PathVariable UUID leadId) {
        return service.findAllByLeadId(leadId);
    }

    @PostMapping
    public NotaFiscalDTO save(@RequestBody NotaFiscalDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public NotaFiscalDTO update(@PathVariable UUID id, @RequestBody NotaFiscalDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
