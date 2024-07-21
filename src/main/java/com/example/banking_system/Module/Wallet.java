package com.example.banking_system.Module;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bs_wallet")
public class Wallet extends RepresentationModel<User> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "bs_user_id", nullable = false)
    private User owner;
    
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    public Boolean isTransferAllowedForWalletType() {
        return this.owner.getType() == "COMUM";
    }

    public boolean isBalancerEqualOrGreaterThen(BigDecimal value) {
        return this.balance.doubleValue() >=  value.doubleValue();
    }

    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }
    
    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }
}
