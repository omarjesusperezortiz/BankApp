package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.DTO.AccountBalanceOnly;
import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.UserRepository;
import com.example.BankProjectIronhack.Services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private UserRepository userRepository;

    //    Esta logica deberia estar bien
    @GetMapping("/account-balance/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountBalanceOnly> getBalance(@PathVariable Long userId){
        return accountHolderService.getBalance(userId);
    }

    //WORKS WELL
    @GetMapping("/accounts-info/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAccountsByUserId(@PathVariable Long userId){
//        return accountRepository.findById(userId).get().getPrimaryOwner().getPrimaryAccountList();
        return accountHolderRepository.findById(userId).get().getPrimaryAccountList();
    }

//Esta logica esta bien
    @PostMapping ("/account-transfer")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal transferAccount(@RequestBody Transfer amount,@RequestParam Long userId){
        accountHolderService.transfer(amount, userId);
        return accountRepository.findById(userId).get().getBalance();
    }

}
