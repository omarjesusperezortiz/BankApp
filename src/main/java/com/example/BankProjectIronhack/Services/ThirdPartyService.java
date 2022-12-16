package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ThirdPartyService {
    @Autowired
    AccountRepository accountRepository;

    public BigDecimal transfer(Transfer transfer, Long BankAccountId) {
        Account bankAccount = accountRepository.findById(BankAccountId).get();
        BigDecimal bankAccountBalance = bankAccount.getBalance();
        bankAccount.setBalance(bankAccountBalance.subtract(transfer.getAmount()));
        accountRepository.save(bankAccount);
        return bankAccountBalance;
    }
}

