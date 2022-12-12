package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Account.Checking;
import com.example.BankProjectIronhack.Models.Account.CreditCard;
import com.example.BankProjectIronhack.Models.Account.Savings;
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
import java.util.List;

@Service
public class AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;

    public BigDecimal getBalance(Long id, String name) {
        if (accountHolderRepository.findByName(name).isPresent() && accountHolderRepository.findById(id).isPresent()) {
            AccountHolder accountHolder = accountHolderRepository.findByName(name).get();
            List<Account> primaryAccountList = accountHolder.getPrimaryAccountList();
            List<Account> secondaryAccountList = accountHolder.getSecondaryAccountList();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User id or User name not found");
}
    public BigDecimal transfer(Transfer amount, Long accountId, String secretKey) {

        return null;
    }

}