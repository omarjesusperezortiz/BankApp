package com.example.BankProjectIronhack.Models.Account;

import com.example.BankProjectIronhack.Models.Enum.Status;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String secretKey;
    @ManyToOne
    private AccountHolder primaryOwner;
    @ManyToOne
    private AccountHolder secondaryOwner;
    private BigDecimal balance;

    //On Review
    private BigDecimal penaltyFee = BigDecimal.valueOf(40) ;

    private Status status = Status.ACTIVE;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate;

    public Account(BigDecimal balance,
                   AccountHolder primaryOwner,
                   String secretKey) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secretKey = secretKey;
        setCreationDate(LocalDate.now());
    }

    //Constructor with secondaryOwner
    public Account(BigDecimal balance,
                   AccountHolder primaryOwner,
                   AccountHolder secondaryOwner,
                   String secretKey) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.secretKey = secretKey;
        setCreationDate(LocalDate.now());
    }


    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                ", balance=" + balance +
                ", penaltyFee=" + penaltyFee +
                ", status=" + status +
                ", creationDate=" + creationDate +
                '}';
    }
}