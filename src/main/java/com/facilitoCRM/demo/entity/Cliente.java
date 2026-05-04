package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "clientes", schema = "crm")
public class Cliente extends Lead {

    private String compraFeita;
    private UUID userId;

    public Cliente() {}

    public String getCompraFeita() { return compraFeita; }
    public void setCompraFeita(String compraFeita) { this.compraFeita = compraFeita; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
}
