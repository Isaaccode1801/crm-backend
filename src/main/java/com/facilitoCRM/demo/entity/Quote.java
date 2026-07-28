package com.facilitoCRM.demo.entity;

import jakarta.persistence.Column;
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
    @Column(name = "lead_id")
    private UUID leadId;

    @Column(name = "servico_id")
    private UUID servicoId;

    @Column(name = "prestador_id")
    private UUID prestadorId;

    @Column(name = "valor_estimado")
    private BigDecimal valorEstimado;

    @Column(name = "valor_negociado")
    private BigDecimal valorNegociado;

    @Column(name = "comissao_percentual")
    private BigDecimal comissaoPercentual;

    private String status;

    private String observacoes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "approved_at")
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

    @Column(name = "pdf_base64")
    private String pdfBase64;

    @Column(name = "pdf_nome")
    private String pdfNome;

    public Quote() {}

    // Getters and Setters
    public String getPdfBase64() { return pdfBase64; }
    public void setPdfBase64(String pdfBase64) { this.pdfBase64 = pdfBase64; }

    public String getPdfNome() { return pdfNome; }
    public void setPdfNome(String pdfNome) { this.pdfNome = pdfNome; }

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
