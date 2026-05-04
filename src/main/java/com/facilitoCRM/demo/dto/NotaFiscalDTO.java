package com.facilitoCRM.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public class NotaFiscalDTO {
    private UUID id;
    @JsonProperty("nome_arquivo")
    private String nomeArquivo;
    private String tipo;
    private Long tamanho;
    @JsonProperty("numero_nf")
    private String numeroNf;
    @JsonProperty("data_emissao")
    private LocalDate dataEmissao;
    @JsonProperty("data_base64")
    private String dataBase64;
    @JsonProperty("lead_id")
    private UUID leadId;
    @JsonProperty("appointment_id")
    private UUID appointmentId;
    @JsonProperty("transaction_id")
    private UUID transactionId;

    public NotaFiscalDTO() {}

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
