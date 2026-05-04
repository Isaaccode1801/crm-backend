package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "prospects", schema = "crm")
public class Prospect {

    @Id
    private UUID id = UUID.randomUUID();

    private String nome;
    private String numero;

    public Prospect() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}
