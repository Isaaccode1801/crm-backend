package com.facilitoCRM.demo.entity;

import jakarta.persistence.*;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "\"Category\"", schema = "public")
@Immutable
public class Category {

    @Id
    private UUID id;

    private String name;

    protected Category() {}

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
}
