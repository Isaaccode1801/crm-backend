package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "facilito_config", schema = "crm")
public class FacilitoConfig {

    @Id
    private UUID id = UUID.randomUUID();

    private BigDecimal comissaoPadraoPercentual;
    private BigDecimal comissaoMinima;
    private BigDecimal comissaoMaxima;
    private String moeda;
    private String nomeEmpresa;

    public FacilitoConfig() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public BigDecimal getComissaoPadraoPercentual() { return comissaoPadraoPercentual; }
    public void setComissaoPadraoPercentual(BigDecimal comissaoPadraoPercentual) { this.comissaoPadraoPercentual = comissaoPadraoPercentual; }

    public BigDecimal getComissaoMinima() { return comissaoMinima; }
    public void setComissaoMinima(BigDecimal comissaoMinima) { this.comissaoMinima = comissaoMinima; }

    public BigDecimal getComissaoMaxima() { return comissaoMaxima; }
    public void setComissaoMaxima(BigDecimal comissaoMaxima) { this.comissaoMaxima = comissaoMaxima; }

    public String getMoeda() { return moeda; }
    public void setMoeda(String moeda) { this.moeda = moeda; }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }
}
