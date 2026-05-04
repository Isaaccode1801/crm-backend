package com.facilitoCRM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lead_history_entries", schema = "crm")
public class LeadHistoryEntry {

    @Id
    private UUID id = UUID.randomUUID();

    private LocalDateTime date;

    @jakarta.persistence.Column(name = "old_status")
    private String oldStatus;
    @jakarta.persistence.Column(name = "new_status")
    private String newStatus;

    @jakarta.persistence.Column(name = "user_email")
    private String userEmail;
    private String type;
    
    @jakarta.persistence.Column(name = "lead_id", insertable = false, updatable = false)
    private UUID leadId;

    @PrePersist
    protected void onCreate() {
        if (this.date == null) {
            this.date = LocalDateTime.now();
        }
    }

    public LeadHistoryEntry() {}

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getOldStatus() { return oldStatus; }
    public void setOldStatus(String oldStatus) { this.oldStatus = oldStatus; }

    public String getNewStatus() { return newStatus; }
    public void setNewStatus(String newStatus) { this.newStatus = newStatus; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public UUID getLeadId() { return leadId; }
    public void setLeadId(UUID leadId) { this.leadId = leadId; }
}
