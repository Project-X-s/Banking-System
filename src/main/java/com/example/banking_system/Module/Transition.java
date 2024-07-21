package com.example.banking_system.Module;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "bs_transition")
public class Transition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name = "wPayer_id", nullable = false)
    private Wallet wPayer;
    
    @ManyToOne
    @JoinColumn(name = "wReceiver_id", nullable = false)
    private Wallet wReceiver;

    @Column(name = "value", nullable = false)
    private BigDecimal value;
    
    @Column(name = "status")
    private Boolean status;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private Timestamp date;

    public Transition(Wallet wPayer, Wallet wReceiver, BigDecimal value) {
        this.wPayer = wPayer;
        this.wReceiver = wReceiver;
        this.value = value;
    }
}
