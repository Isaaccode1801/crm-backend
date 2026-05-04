package com.facilitoCRM.demo.controller;

import com.facilitoCRM.demo.dto.PublicServiceDetailedDTO;
import com.facilitoCRM.demo.service.PublicServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public-services")
@CrossOrigin(origins = "http://localhost:8081")
public class PublicServiceController {

    @Autowired
    private PublicServiceService service;

    @GetMapping
    public List<PublicServiceDetailedDTO> findAllDetailed() {
        return service.findAllDetailed();
    }
}
