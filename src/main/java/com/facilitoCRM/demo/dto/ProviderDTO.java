package com.facilitoCRM.demo.dto;

import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ProviderDTO(
    UUID id,
    String companyname,
    String responsavel,
    String email,
    String phone,
    String address,
    String city,
    String state,
    String cep,
    BigDecimal ratingMedio,
    BigDecimal commissionRate,
    String[] especialidades,
    List<PublicServiceDTO> services,
    OffsetDateTime createdAt
) {}
