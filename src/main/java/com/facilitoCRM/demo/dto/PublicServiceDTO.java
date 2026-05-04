package com.facilitoCRM.demo.dto;

import java.util.UUID;
import java.time.OffsetDateTime;

public record PublicServiceDTO(
    UUID id,
    String title,
    String description,
    Double price,
    Boolean active,
    String categoria,
    OffsetDateTime createdAt
) {}
