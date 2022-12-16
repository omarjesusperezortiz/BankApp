package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;
    @Autowired
    AccountRepository accountRepository;

//Works
    @PostMapping ("/third-party-transfer")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal transferAccount(@RequestBody Transfer amount,@RequestParam Long userId){
        thirdPartyService.transfer(amount, userId);
        return accountRepository.findById(userId).get().getBalance();
    }
}
