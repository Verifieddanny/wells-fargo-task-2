package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;

    protected Portfolio() {

    }

    public Portfolio(Client client) {
        this.client = client;
    }

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
