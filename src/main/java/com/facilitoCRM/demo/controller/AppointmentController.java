package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.entity.Appointment;
import com.facilitoCRM.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:8081")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @GetMapping("/lead/{leadId}")
    public List<Appointment> findAllByLeadId(@PathVariable UUID leadId) {
        return repository.findByLeadId(leadId);
    }

    @GetMapping
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable UUID id, @RequestBody Appointment entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
