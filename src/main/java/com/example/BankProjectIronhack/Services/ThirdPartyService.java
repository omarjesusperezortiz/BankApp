package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ThirdPartyService {
    @Autowired
    AccountRepository accountRepository;

    public BigDecimal transfer(Transfer amount,Long accountId, String hashedKey) {

        return null;
    }
}

