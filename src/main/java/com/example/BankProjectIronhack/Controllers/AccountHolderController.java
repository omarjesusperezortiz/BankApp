package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;

    @GetMapping("/account-balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getBalance(@RequestParam Long id, @RequestHeader String secretKey){
        return accountHolderService.getBalance(id, secretKey);
    }

    @PostMapping ("/account-transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transferAccount(Transfer amount,@RequestParam Long userId, @RequestHeader String secretKey){
        accountHolderService.transfer(amount, userId, secretKey);
    }

}
