package com.example.BankProjectIronhack.Models.Account;

import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class StudentChecking extends Account {

    public StudentChecking(BigDecimal balance, String secretKey, AccountHolder primaryOwner) {
        super(balance,primaryOwner,secretKey);
    }
    public StudentChecking(BigDecimal balance, String secretKey,
                           AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance,primaryOwner,secondaryOwner,secretKey);
    }

    public StudentChecking() {}

}