package com.facilitoCRM.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

public class LeadHistoryEntryDTO {
    private UUID id;
    private LocalDateTime date;
    @JsonProperty("old_status")
    private String oldStatus;
    @JsonProperty("new_status")
    private String newStatus;
    @JsonProperty("user")
    private String userEmail;
    private String type;
    @JsonProperty("lead_id")
    private UUID leadId;
    private String note;

    public LeadHistoryEntryDTO() {}

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

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
