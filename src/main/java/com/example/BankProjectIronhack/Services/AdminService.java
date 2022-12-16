package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Account.*;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Models.Users.User;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.SavingsRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AdminRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.ThirdPartyRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AdminRepository adminRepository;


    //CREATE ACCOUNT BUSINESS LOGIC
    public Account createChecking(Checking checking) {
            Period checkAge = Period.between(checking.getPrimaryOwner().getDateOfBirth(), LocalDate.now());
            if (checkAge.getYears() < 24) {
                StudentChecking studentChecking =
                        new StudentChecking(checking.getBalance(),
                                checking.getSecretKey(),
                                checking.getPrimaryOwner());
                return accountRepository.save(studentChecking);
            } else {
                return accountRepository.save(checking);
            }
        }

    public Account createSavings(Savings savings) {
        return accountRepository.save(savings);
    }

    public Account createCreditCard(CreditCard creditCard) {
            return accountRepository.save(creditCard);
    }

    //CREATE USERS LOGIC
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

//    WORKS
    public ThirdParty createThirdParty(ThirdParty thirdParty) {
        return thirdPartyRepository.save(thirdParty);
    }

    public void modifyBalance(Long accountId, BigDecimal balance){
        if(accountRepository.findById(accountId).isPresent()){

            Account accountModified = accountRepository.findById(accountId).get();
            accountModified.setBalance(balance);
            accountRepository.save(accountModified);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist");
        }
    }

    public void deleteAccount(Long accountId) {
        if(accountRepository.findById(accountId).isPresent()){
            accountRepository.deleteById(accountId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist");
        }
    }

    //UN ADMIN NO PUEDE BORRAR A OTRO ADMIN POR LO QUE LA LOGICA APLICA SOLO A ACCOUNT HOLDERS Y THIRDPARTIES
    public void deleteUser(Long userId) {
        if(accountHolderRepository.findById(userId).isPresent()){
            accountHolderRepository.deleteById(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist");
        }
    }

}
