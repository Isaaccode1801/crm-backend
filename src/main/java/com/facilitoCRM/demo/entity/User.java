package com.facilitoCRM.demo.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "\"User\"", schema = "public")
@Immutable
public class User {

    @Id
    private UUID id;

    private String email;
    private String name;
    private String phone;

    @Column(name = "createdat")
    private OffsetDateTime createdAt;

    @Column(name = "avatar_url")
    private String avatarUrl;

    private String cpf;

    protected User() {}

    // Getters
    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getCpf() { return cpf; }
}
