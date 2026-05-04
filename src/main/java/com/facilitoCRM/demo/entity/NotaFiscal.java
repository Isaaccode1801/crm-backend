package com.facilitoCRM.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "notas_fiscais", schema = "crm")
public class NotaFiscal {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "nome_arquivo")
    @JsonProperty("nome_arquivo")
    private String nomeArquivo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tamanho")
    private Long tamanho;

    @Column(name = "numero_nf")
    @JsonProperty("numero_nf")
    private String numeroNf;

    @Column(name = "data_emissao")
    @JsonProperty("data_emissao")
    private LocalDate dataEmissao;

    @JsonProperty("data_base64")
    private String dataBase64;

    @Column(name = "lead_id")
    @JsonProperty("lead_id")
    private UUID leadId;

    @Column(name = "appointment_id")
    @JsonProperty("appointment_id")
    private UUID appointmentId;

    @Column(name = "transaction_id")
    @JsonProperty("transaction_id")
    private UUID transactionId;

    public NotaFiscal() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNomeArquivo() { return nomeArquivo; }
    public void setNomeArquivo(String nomeArquivo) { this.nomeArquivo = nomeArquivo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Long getTamanho() { return tamanho; }
    public void setTamanho(Long tamanho) { this.tamanho = tamanho; }

    public String getNumeroNf() { return numeroNf; }
    public void setNumeroNf(String numeroNf) { this.numeroNf = numeroNf; }

    public LocalDate getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(LocalDate dataEmissao) { this.dataEmissao = dataEmissao; }

    public String getDataBase64() { return dataBase64; }
    public void setDataBase64(String dataBase64) { this.dataBase64 = dataBase64; }

    public UUID getLeadId() { return leadId; }
    public void setLeadId(UUID leadId) { this.leadId = leadId; }

    public UUID getAppointmentId() { return appointmentId; }
    public void setAppointmentId(UUID appointmentId) { this.appointmentId = appointmentId; }

    public UUID getTransactionId() { return transactionId; }
    public void setTransactionId(UUID transactionId) { this.transactionId = transactionId; }
}
