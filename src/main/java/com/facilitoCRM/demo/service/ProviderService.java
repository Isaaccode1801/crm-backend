package com.facilitoCRM.demo.service;

import com.facilitoCRM.demo.dto.ProviderDTO;
import com.facilitoCRM.demo.dto.PublicServiceDTO;
import com.facilitoCRM.demo.entity.Provider;
import com.facilitoCRM.demo.entity.PublicService;
import com.facilitoCRM.demo.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository repository;

    public List<ProviderDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProviderDTO findById(UUID id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    private ProviderDTO toDTO(Provider provider) {
        List<PublicServiceDTO> services = provider.getServices() == null ? List.of() :
                provider.getServices().stream()
                        .map(this::toPublicServiceDTO)
                        .collect(Collectors.toList());

        String email = provider.getUser() != null ? provider.getUser().getEmail() : null;

        return new ProviderDTO(
                provider.getId(),
                provider.getCompanyname(),
                provider.getResponsavel(),
                email,
                provider.getPhone(),
                provider.getAddress(),
                provider.getCity(),
                provider.getState(),
                provider.getCep(),
                provider.getRatingMedio(),
                provider.getCommission_rate(),
                provider.getEspecialidades(),
                services,
                provider.getCreatedAt()
        );
    }

    private PublicServiceDTO toPublicServiceDTO(PublicService service) {
        return new PublicServiceDTO(
                service.getId(),
                service.getTitle(),
                service.getDescription(),
                service.getPrice(),
                service.getActive(),
                service.getCategoria(),
                service.getCreatedAt()
        );
    }
}
