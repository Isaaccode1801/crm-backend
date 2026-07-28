package com.facilitoCRM.demo.entity;

import com.facilitoCRM.demo.entity.enums.StatusAppointment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments", schema = "crm")
public class Appointment {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "lead_id")
    private UUID leadId;

    @Column(name = "prestador_id")
    private UUID prestadorId;

    @Column(name = "servico_id")
    private UUID servicoId;

    @Column(name = "nota_fiscal_id")
    private UUID notaFiscalId;

    @Column(name = "quote_id")
    private UUID quoteId;

    private BigDecimal valor;

    @Column(name = "comissao_percentual")
    private BigDecimal comissaoPercentual;

    private BigDecimal comissao;

    @Enumerated(EnumType.STRING)
    private StatusAppointment status;

    @Column(name = "data_execucao")
    private LocalDateTime dataExecucao;

    private String observacoes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Appointment() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getLeadId() { return leadId; }
    public void setLeadId(UUID leadId) { this.leadId = leadId; }

    public UUID getPrestadorId() { return prestadorId; }
    public void setPrestadorId(UUID prestadorId) { this.prestadorId = prestadorId; }

    public UUID getServicoId() { return servicoId; }
    public void setServicoId(UUID servicoId) { this.servicoId = servicoId; }

    public UUID getNotaFiscalId() { return notaFiscalId; }
    public void setNotaFiscalId(UUID notaFiscalId) { this.notaFiscalId = notaFiscalId; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public BigDecimal getComissaoPercentual() { return comissaoPercentual; }
    public void setComissaoPercentual(BigDecimal comissaoPercentual) { this.comissaoPercentual = comissaoPercentual; }

    public BigDecimal getComissao() { return comissao; }
    public void setComissao(BigDecimal comissao) { this.comissao = comissao; }

    public StatusAppointment getStatus() { return status; }
    public void setStatus(StatusAppointment status) { this.status = status; }

    public LocalDateTime getDataExecucao() { return dataExecucao; }
    public void setDataExecucao(LocalDateTime dataExecucao) { this.dataExecucao = dataExecucao; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public UUID getQuoteId() { return quoteId; }
    public void setQuoteId(UUID quoteId) { this.quoteId = quoteId; }
}
