package com.facilitoCRM.demo.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "\"Service\"", schema = "public")
@Immutable
public class PublicService {

    @Id
    private UUID id;

    @Column(name = "providerid")
    private UUID providerId;

    @Column(name = "category_id")
    private UUID categoryId;

    private String title;
    private String description;
    private Double price;
    private Boolean active;

    @Column(name = "createdat")
    private OffsetDateTime createdAt;

    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerid", referencedColumnName = "id", insertable = false, updatable = false)
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    protected PublicService() {}

    // Getters
    public UUID getId() { return id; }
    public UUID getProviderId() { return providerId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public Boolean getActive() { return active; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public String getCategoria() { return categoria; }
    public UUID getCategoryId() { return categoryId; }
    public Provider getProvider() { return provider; }
    public Category getCategory() { return category; }
}
