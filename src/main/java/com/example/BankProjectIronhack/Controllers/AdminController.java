package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Account.Checking;
import com.example.BankProjectIronhack.Models.Account.CreditCard;
import com.example.BankProjectIronhack.Models.Account.Savings;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.Address;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Models.Users.User;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.ThirdPartyRepository;
import com.example.BankProjectIronhack.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

//    Admins should be able to:
//    access the balance for any account
//    and to modify it.

//WORKS
    @GetMapping("/all-accounts")
    public List<Account> checkAllAccount() {
        return accountRepository.findAll();
    }

//WORKS
    @GetMapping("/all-third-parties")
    public List<ThirdParty> checkAllThirdParties() {
        return thirdPartyRepository.findAll();
    }

    @PostMapping("/create-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking(@RequestBody Checking checking) {
        return adminService.createChecking(checking);
    }

//    WORKS
    @PostMapping("/create-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty){
        return adminService.createThirdParty(thirdParty);
    }

    @PostMapping("/create-savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createSavings(@RequestBody Savings savings){
        return adminService.createSavings(savings);
    }

    @PostMapping("/create-accountHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolder accountHolder){
        return adminService.createAccountHolder(accountHolder);
    }

    @DeleteMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@RequestParam Long accountId){
        adminService.deleteAccount(accountId);
    }
    }

