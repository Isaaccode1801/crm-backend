package com.facilitoCRM.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import java.util.Set;

@Entity
@Table(name = "\"ProviderProfile\"", schema = "public")
@Immutable 
public class Provider {

    @Id
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    private String companyname;
    private String cnpj;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String cep;

    @Column(name = "createdat")
    private OffsetDateTime createdAt;

    @Column(name = "avatar_url")
    private String avatarUrl;

    private String responsavel;

    @Column(name = "rating_medio")
    private BigDecimal ratingMedio;

    private String bio;

    private String[] especialidades;

    private BigDecimal commission_rate;
    private String pix_key;
    private String pix_key_type;
    private BigDecimal carteira;
    
    private String banco_codigo;
    private String agencia;
    private String agencia_dv;
    private String conta;
    private String conta_dv;
    private String tipo_conta;
    private String documento_titular;
    
    private String pagarme_recipient_id;
    private String stripe_account_id;
    private Boolean stripe_onboarding_complete;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "providerid", referencedColumnName = "id", insertable = false, updatable = false)
    private Set<PublicService> services;

    protected Provider() {}

    // Getters
    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public String getCompanyname() { return companyname; }
    public String getCnpj() { return cnpj; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCep() { return cep; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getResponsavel() { return responsavel; }
    public BigDecimal getRatingMedio() { return ratingMedio; }
    public String getBio() { return bio; }
    public String[] getEspecialidades() { return especialidades; }
    public BigDecimal getCommission_rate() { return commission_rate; }
    public String getPix_key() { return pix_key; }
    public String getPix_key_type() { return pix_key_type; }
    public BigDecimal getCarteira() { return carteira; }
    public String getBanco_codigo() { return banco_codigo; }
    public String getAgencia() { return agencia; }
    public String getAgencia_dv() { return agencia_dv; }
    public String getConta() { return conta; }
    public String getConta_dv() { return conta_dv; }
    public String getTipo_conta() { return tipo_conta; }
    public String getDocumento_titular() { return documento_titular; }
    public String getPagarme_recipient_id() { return pagarme_recipient_id; }
    public String getStripe_account_id() { return stripe_account_id; }
    public Boolean getStripe_onboarding_complete() { return stripe_onboarding_complete; }

    public User getUser() { return user; }
    public Set<PublicService> getServices() { return services; }
}
