package com.facilitoCRM.demo.service;

import com.facilitoCRM.demo.dto.PublicServiceDetailedDTO;
import com.facilitoCRM.demo.entity.PublicService;
import com.facilitoCRM.demo.repository.PublicServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicServiceService {

    @Autowired
    private PublicServiceRepository repository;

    public List<PublicServiceDetailedDTO> findAllDetailed() {
        return repository.findAll().stream()
                .map(this::toDetailedDTO)
                .collect(Collectors.toList());
    }

    private PublicServiceDetailedDTO toDetailedDTO(PublicService service) {
        String categoriaName = service.getCategory() != null ? service.getCategory().getName() : service.getCategoria();
        
        java.math.BigDecimal commission = null;
        String providerName = null;
        
        if (service.getProvider() != null) {
            commission = service.getProvider().getCommission_rate();
            providerName = service.getProvider().getCompanyname();
        }

        return new PublicServiceDetailedDTO(
                service.getId(),
                service.getTitle(),
                categoriaName,
                service.getPrice(),
                commission,
                providerName,
                service.getActive()
        );
    }
}
