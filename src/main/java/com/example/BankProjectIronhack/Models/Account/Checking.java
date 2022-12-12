package com.example.BankProjectIronhack.Models.Account;

import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import jakarta.persistence.Entity;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account {
    private BigDecimal minimumBalance = BigDecimal.valueOf(250);
    private BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(12);
//vamo a revisarlo
    private LocalDate monthlyMaintenanceDate;

    public Checking(BigDecimal balance,
                    String secretKey,
                    AccountHolder primaryOwner) {
        super(balance, primaryOwner, secretKey);
        setMonthlyMaintenanceDate(LocalDate.now());
    }

    public Checking(BigDecimal balance,
                    String secretKey,
                    AccountHolder primaryOwner,
                    AccountHolder secondaryOwner) {
        super(balance, primaryOwner,secondaryOwner, secretKey);
        setMonthlyMaintenanceDate(LocalDate.now());
    }

    public Checking() {
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public LocalDate getMonthlyMaintenanceDate() {
        return monthlyMaintenanceDate;
    }

    public void setMonthlyMaintenanceDate(LocalDate monthlyMaintenanceDate) {
        this.monthlyMaintenanceDate = monthlyMaintenanceDate;
    }


}
