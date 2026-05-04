package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "quotes", schema = "crm")
public class Quote {

    @Id
    private UUID id = UUID.randomUUID();

    // UUIDs
    private UUID leadId;
    private UUID servicoId;
    private UUID prestadorId;

    private BigDecimal valorEstimado;
    private BigDecimal valorNegociado;
    private BigDecimal comissaoPercentual;

    private String status;

    private String observacoes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime approvedAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        if ("APROVADO".equals(this.status) && this.approvedAt == null) {
            this.approvedAt = LocalDateTime.now();
        }
    }

    public Quote() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getLeadId() { return leadId; }
    public void setLeadId(UUID leadId) { this.leadId = leadId; }

    public UUID getServicoId() { return servicoId; }
    public void setServicoId(UUID servicoId) { this.servicoId = servicoId; }

    public UUID getPrestadorId() { return prestadorId; }
    public void setPrestadorId(UUID prestadorId) { this.prestadorId = prestadorId; }

    public BigDecimal getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(BigDecimal valorEstimado) { this.valorEstimado = valorEstimado; }

    public BigDecimal getValorNegociado() { return valorNegociado; }
    public void setValorNegociado(BigDecimal valorNegociado) { this.valorNegociado = valorNegociado; }

    public BigDecimal getComissaoPercentual() { return comissaoPercentual; }
    public void setComissaoPercentual(BigDecimal comissaoPercentual) { this.comissaoPercentual = comissaoPercentual; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getApprovedAt() { return approvedAt; }
    public void setApprovedAt(LocalDateTime approvedAt) { this.approvedAt = approvedAt; }
}
