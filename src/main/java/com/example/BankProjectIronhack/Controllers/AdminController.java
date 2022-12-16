package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Account.Checking;
import com.example.BankProjectIronhack.Models.Account.CreditCard;
import com.example.BankProjectIronhack.Models.Account.Savings;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Models.DTO.AccountBalanceOnly;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.ThirdPartyRepository;
import com.example.BankProjectIronhack.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

//    Admins should be able to:
//    access the balance for any account
//    and to modify it.

//WORKS
    @GetMapping("/all-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> checkAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/all-users")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> checkAllUsers() {
        return accountHolderRepository.findAll();
    }

//WORKS
    @GetMapping("/all-third-parties")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> checkAllThirdParties() {
        return thirdPartyRepository.findAll();
    }

//    Create Accounts

    //WORKS
    @PostMapping("/create-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking(@RequestBody Checking checking) {
        return adminService.createChecking(checking);
    }

    //WORKS
    @PostMapping("/create-savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createSavings(@RequestBody Savings savings){
        return adminService.createSavings(savings);
    }

    //WORKS
    @PostMapping("/create-credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createSavings(@RequestBody CreditCard creditCard){
        return adminService.createCreditCard(creditCard);
    }
//CREATE USERS
    //I ASSUME ADMINS CAN NOT CREATE ADMINS, ONLY A SUPER ADMIN
//    WORKS
    @PostMapping("/create-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty){
        return adminService.createThirdParty(thirdParty);
    }

    //WORKS
    @PostMapping("/create-accountHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolder accountHolder){
        return adminService.createAccountHolder(accountHolder);
    }

    //MODIFY BALANCE
    //WORKS :')
    @PatchMapping("/account-balance-update/{accountId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void modifyBalanceAccount(@PathVariable("accountId") Long accountId, @RequestBody AccountBalanceOnly balance){
       adminService.modifyBalance(accountId,balance.getBalance());
    }


    //DELETES
    //WORKS
    @DeleteMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable Long accountId){
        adminService.deleteAccount(accountId);
    }
    // DELETE ACCOUNTHOLDERS ONLY
    //WORKS
    @DeleteMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable Long userId){
        adminService.deleteUser(userId);
    }

    }

