package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Account.Checking;
import com.example.BankProjectIronhack.Models.Account.CreditCard;
import com.example.BankProjectIronhack.Models.Account.Savings;
import com.example.BankProjectIronhack.Models.DTO.AccountBalanceOnly;
import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<AccountBalanceOnly> getBalance(Long userId) {
                List<Account> accountList = accountHolderRepository.findById(userId).get().getPrimaryAccountList();

                List<AccountBalanceOnly> accountBalances = new ArrayList<>();

                for (Account i: accountList) {
                   accountBalances.add(new AccountBalanceOnly(i.getBalance()));
            }

        return accountBalances;
    }


    public BigDecimal transfer(Transfer transfer, Long BankAccountId) {
            Account bankAccount = accountRepository.findById(BankAccountId).get();
            BigDecimal bankAccountBalance = bankAccount.getBalance();
            bankAccount.setBalance(bankAccountBalance.subtract(transfer.getAmount()));
            accountRepository.save(bankAccount);
            return bankAccountBalance;
    }

}