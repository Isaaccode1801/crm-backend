package com.facilitoCRM.demo.entity;

import com.facilitoCRM.demo.entity.enums.StatusPagamento;
import com.facilitoCRM.demo.entity.enums.StatusRepasse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "financial_transactions", schema = "crm")
public class FinancialTransaction {

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

    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "comissao_percentual")
    private BigDecimal comissaoPercentual;
    @Column(name = "valor_comissao")
    private BigDecimal valorComissao;
    @Column(name = "valor_repasse")
    private BigDecimal valorRepasse;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento_cliente")
    private StatusPagamento statusPagamentoCliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_repasse_prestador")
    private StatusRepasse statusRepassePrestador;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "metodo_pagamento")
    private String metodoPagamento;
    
    @Column(name = "observacoes")
    private String observacoes;
    
    @Column(name = "is_app")
    private Boolean isApp;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public FinancialTransaction() {}

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

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public BigDecimal getComissaoPercentual() { return comissaoPercentual; }
    public void setComissaoPercentual(BigDecimal comissaoPercentual) { this.comissaoPercentual = comissaoPercentual; }

    public BigDecimal getValorComissao() { return valorComissao; }
    public void setValorComissao(BigDecimal valorComissao) { this.valorComissao = valorComissao; }

    public BigDecimal getValorRepasse() { return valorRepasse; }
    public void setValorRepasse(BigDecimal valorRepasse) { this.valorRepasse = valorRepasse; }

    public StatusPagamento getStatusPagamentoCliente() { return statusPagamentoCliente; }
    public void setStatusPagamentoCliente(StatusPagamento statusPagamentoCliente) { this.statusPagamentoCliente = statusPagamentoCliente; }

    public StatusRepasse getStatusRepassePrestador() { return statusRepassePrestador; }
    public void setStatusRepassePrestador(StatusRepasse statusRepassePrestador) { this.statusRepassePrestador = statusRepassePrestador; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getMetodoPagamento() { return metodoPagamento; }
    public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Boolean getIsApp() { return isApp; }
    public void setIsApp(Boolean isApp) { this.isApp = isApp; }
}
