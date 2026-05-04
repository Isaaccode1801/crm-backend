package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.UUID;

@Entity
@Table(name = "compras", schema = "crm")
public class Compra {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "service_id")
    private UUID serviceId;

    @Column(name = "lead_id")
    private UUID leadId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "transaction_id")
    private UUID transactionId;

    public Compra() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getServiceId() { return serviceId; }
    public void setServiceId(UUID serviceId) { this.serviceId = serviceId; }

    public UUID getLeadId() { return leadId; }
    public void setLeadId(UUID leadId) { this.leadId = leadId; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public UUID getTransactionId() { return transactionId; }
    public void setTransactionId(UUID transactionId) { this.transactionId = transactionId; }
}
