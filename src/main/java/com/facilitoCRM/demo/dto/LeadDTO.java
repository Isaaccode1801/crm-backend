package com.facilitoCRM.demo.dto;

import com.facilitoCRM.demo.entity.NotaFiscal;
import com.facilitoCRM.demo.dto.NotaFiscalDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.List;

public class LeadDTO {
    private UUID id;
    private String nome;
    private String email;
    @JsonProperty("telefone")
    private String telefone;
    private String cpf;
    private UUID interesse;
    private BigDecimal precoInteresse;
    private String interesseNaoListado;
    private String tipoImovel;
    private String relacaoImovel;
    private String enderecoCep;
    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoUf;
    private UUID servicoId;
    private UUID prestadorId;
    private UUID externalSolicitacaoId;
    private String statusFunil;
    private String origem;
    private String prioridade;
    private BigDecimal valorEstimado;
    private BigDecimal valorNegociado;
    private BigDecimal valorFechado;
    private BigDecimal comissaoPercentual;
    private BigDecimal comissao;
    private LocalDate followUpDate;
    private LocalDateTime conversionStageDate;
    private OffsetDateTime createdAt;
    private String observacoes;
    private String externalSource;
    private String externalId;
    @JsonProperty("notas_fiscais")
    private List<NotaFiscalDTO> notasFiscais;
    @JsonProperty("historico")
    private List<LeadHistoryEntryDTO> historico;

    public LeadDTO() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public List<NotaFiscalDTO> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(List<NotaFiscalDTO> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public List<LeadHistoryEntryDTO> getHistorico() {
        return historico;
    }

    public void setHistorico(List<LeadHistoryEntryDTO> historico) {
        this.historico = historico;
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public UUID getInteresse() { return interesse; }
    public void setInteresse(UUID interesse) { this.interesse = interesse; }

    public BigDecimal getPrecoInteresse() { return precoInteresse; }
    public void setPrecoInteresse(BigDecimal precoInteresse) { this.precoInteresse = precoInteresse; }

    public String getInteresseNaoListado() { return interesseNaoListado; }
    public void setInteresseNaoListado(String interesseNaoListado) { this.interesseNaoListado = interesseNaoListado; }

    public String getTipoImovel() { return tipoImovel; }
    public void setTipoImovel(String tipoImovel) { this.tipoImovel = tipoImovel; }

    public String getRelacaoImovel() { return relacaoImovel; }
    public void setRelacaoImovel(String relacaoImovel) { this.relacaoImovel = relacaoImovel; }

    public String getEnderecoCep() { return enderecoCep; }
    public void setEnderecoCep(String enderecoCep) { this.enderecoCep = enderecoCep; }

    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }

    public String getEnderecoNumero() { return enderecoNumero; }
    public void setEnderecoNumero(String enderecoNumero) { this.enderecoNumero = enderecoNumero; }

    public String getEnderecoComplemento() { return enderecoComplemento; }
    public void setEnderecoComplemento(String enderecoComplemento) { this.enderecoComplemento = enderecoComplemento; }

    public String getEnderecoBairro() { return enderecoBairro; }
    public void setEnderecoBairro(String enderecoBairro) { this.enderecoBairro = enderecoBairro; }

    public String getEnderecoCidade() { return enderecoCidade; }
    public void setEnderecoCidade(String enderecoCidade) { this.enderecoCidade = enderecoCidade; }

    public String getEnderecoUf() { return enderecoUf; }
    public void setEnderecoUf(String enderecoUf) { this.enderecoUf = enderecoUf; }

    public UUID getServicoId() { return servicoId; }
    public void setServicoId(UUID servicoId) { this.servicoId = servicoId; }

    public UUID getPrestadorId() { return prestadorId; }
    public void setPrestadorId(UUID prestadorId) { this.prestadorId = prestadorId; }

    public UUID getExternalSolicitacaoId() { return externalSolicitacaoId; }
    public void setExternalSolicitacaoId(UUID externalSolicitacaoId) { this.externalSolicitacaoId = externalSolicitacaoId; }

    public String getStatusFunil() { return statusFunil; }
    public void setStatusFunil(String statusFunil) { this.statusFunil = statusFunil; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public BigDecimal getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(BigDecimal valorEstimado) { this.valorEstimado = valorEstimado; }

    public BigDecimal getValorNegociado() { return valorNegociado; }
    public void setValorNegociado(BigDecimal valorNegociado) { this.valorNegociado = valorNegociado; }

    public BigDecimal getValorFechado() { return valorFechado; }
    public void setValorFechado(BigDecimal valorFechado) { this.valorFechado = valorFechado; }

    public BigDecimal getComissaoPercentual() { return comissaoPercentual; }
    public void setComissaoPercentual(BigDecimal comissaoPercentual) { this.comissaoPercentual = comissaoPercentual; }

    public BigDecimal getComissao() { return comissao; }
    public void setComissao(BigDecimal comissao) { this.comissao = comissao; }

    public LocalDate getFollowUpDate() { return followUpDate; }
    public void setFollowUpDate(LocalDate followUpDate) { this.followUpDate = followUpDate; }

    public LocalDateTime getConversionStageDate() { return conversionStageDate; }
    public void setConversionStageDate(LocalDateTime conversionStageDate) { this.conversionStageDate = conversionStageDate; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getExternalSource() { return externalSource; }
    public void setExternalSource(String externalSource) { this.externalSource = externalSource; }

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }
}
