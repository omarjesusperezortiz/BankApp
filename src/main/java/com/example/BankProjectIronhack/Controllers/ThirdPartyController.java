package com.example.BankProjectIronhack.Controllers;

import com.example.BankProjectIronhack.Models.Other.Transfer;
import com.example.BankProjectIronhack.Services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/transfer-thirdParty")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal transfer(@RequestHeader Transfer amount,Long userId, String hashedKey){
        return thirdPartyService.transfer(amount, userId, hashedKey);
    }
}
