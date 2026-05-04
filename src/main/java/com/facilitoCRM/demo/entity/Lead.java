package com.facilitoCRM.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "leads", schema = "crm")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lead {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String nome;

    private String email;
    @Column(name = "telefone")
    private String telefone;
    private String cpf;

    // Interesse
    private UUID interesse;
    private BigDecimal precoInteresse;
    private String interesseNaoListado;

    // Imovel
    // Imovel
    private String tipoImovel;
    private String relacaoImovel;

    // Endereco
    @Column(name = "endereco_cep")
    private String enderecoCep;
    @Column(name = "endereco_rua")
    private String enderecoRua;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_cidade")
    private String enderecoCidade;
    @Column(name = "endereco_uf")
    private String enderecoUf;

    // Relacoes (IDs)
    private UUID servicoId;
    private UUID prestadorId;
    private UUID externalSolicitacaoId;

    // Funil Comercial
    // Funil Comercial
    private String statusFunil;
    private String origem;
    private String prioridade;

    // Valores
    private BigDecimal valorEstimado;
    private BigDecimal valorNegociado;
    private BigDecimal valorFechado;
    private BigDecimal comissaoPercentual;
    private BigDecimal comissao;

    // Datas/Acompanhamento
    private LocalDate followUpDate;
    private LocalDateTime conversionStageDate;
    private OffsetDateTime createdAt;

    // Campos Auxiliares
    private String observacoes;
    private String externalSource;
    private String externalId;

    // Relacionamentos Internos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lead_id")
    private List<NotaFiscal> notasFiscais = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lead_id")
    private List<LeadHistoryEntry> historico = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = OffsetDateTime.now();
        }
    }

    public Lead() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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

    public List<NotaFiscal> getNotasFiscais() { return notasFiscais; }
    public void setNotasFiscais(List<NotaFiscal> notasFiscais) { this.notasFiscais = notasFiscais; }

    public List<LeadHistoryEntry> getHistorico() { return historico; }
    public void setHistorico(List<LeadHistoryEntry> historico) { this.historico = historico; }
}
