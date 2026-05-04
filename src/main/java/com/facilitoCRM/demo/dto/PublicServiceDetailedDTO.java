package com.facilitoCRM.demo.dto;

import java.util.UUID;
import java.math.BigDecimal;

public record PublicServiceDetailedDTO(
    UUID id,
    String nome,
    String categoria,
    Double precoBase,
    BigDecimal comissaoPercentual,
    String prestadores,
    Boolean status
) {}
