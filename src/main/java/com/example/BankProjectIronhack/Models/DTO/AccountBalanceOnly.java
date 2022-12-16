package com.example.BankProjectIronhack.Models.DTO;

import java.math.BigDecimal;

public class AccountBalanceOnly {

    BigDecimal balance;

    public AccountBalanceOnly(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
